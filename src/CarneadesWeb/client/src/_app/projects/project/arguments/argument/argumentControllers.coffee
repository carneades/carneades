# Copyright (c) 2014 Fraunhofer Gesellschaft
# This Source Code Form is subject to the terms of the Mozilla Public
# License, v. 2.0. If a copy of the MPL was not distributed with this
# file, You can obtain one at http://mozilla.org/MPL/2.0/.

define [
  'angular',
  'angular-capitalize-filter',
  'angular-translate'
], (angular) ->

  addPremise = (scope) ->
    scope.argument.premises.push({role: "", implicit: false, positive: true})

  deletePremise = (scope, p) ->
    scope.argument.premises = (q for q in scope.argument.premises when p.role != q.role)

  onArgumentRetrieve = (scope) ->
    scope.schemeId = if scope.argument.scheme? and scope.argument.scheme != "" and scope.argument.scheme[0] == '('
      scope.argument.scheme.slice 1, -1
    else
      undefined

  onSchemeChange = (scope, newVal) ->
    if newVal == undefined
      return

    scope.argument.scheme = "(#{newVal})"

    scope.currentScheme = if scope.theory.schemes?
      (scope.theory.schemes.filter (s) ->
        s.id == newVal)[0]
    else
      undefined

    if scope.currentScheme?
      premises = ({role: p.role, positive: true, implicit: false} for p in scope.currentScheme.premises)
      # set up the role of the premises but try keeping the statements
      i = 0
      for p in premises
        premise = if scope.argument.premises? and scope.argument.premises[i]?
          scope.argument.premises[i]

        if premise?
          p.statement = premise.statement
        i++

      scope.argument.premises = premises


  angular.module('argument.controllers', [
    'pascalprecht.translate',
    'angular-capitalize-filter',
    'directives.metadata'
  ])

  .controller('ArgumentViewCtrl', ($scope, argument, project, $translate) ->
    $scope.argument = argument
    $scope.argument.valueText =
      if $scope.argument.value <= 0.25
        $translate.instant 'projects.argument.value.unacceptable'
      else if $scope.argument.value >= 0.75
        $translate.instant 'projects.argument.value.acceptable'
      else
        $translate.instant 'projects.argument.value.unclear'

    $scope.pid = $scope.$stateParams.pid
    $scope.db = $scope.$stateParams.db

    $scope.headerIsEmpty = (v for k,v of argument.header when v?).length == 0

    $scope.project = project
    if argument.scheme
      $scope.$state.$current.self.tooltip = argument.scheme.header.title
    else
      $scope.$state.$current.self.tooltip = argument.id

    $scope.conclusion_text =
      if argument.strict and argument.pro
        $translate.instant 'projects.strict_pro_conclusion'
      else if argument.strict and not argument.pro
        $translate.instant 'projects.strict_con_conclusion'
      else if not argument.strict and argument.pro
        $translate.instant 'projects.nonstrict_pro_conclusion'
      else if not argument.strict and not argument.pro
        $translate.instant 'projects.nonstrict_con_conclusion'
  )

  .controller('ArgumentCreateCtrl', ($scope, $stateParams, $translate, project, theory, projectInfo, statements, argumentcreate) ->
    $scope.title = $translate.instant 'projects.createargument'
    $scope.statements = statements.query $stateParams

    $scope.argument =
      pro: true
      strict: false
      premises: []
      scheme: ""

    $scope.theory = theory.get {
      pid: $stateParams.pid,
      db: $stateParams.db,
      tpid: projectInfo.getSchemesProject(project),
      tid: projectInfo.getSchemesName(project)
    }

    $scope.onSave = ->
      argumentcreate.save $stateParams, $scope.argument

    $scope.$watch 'schemeId', (newVal) ->
      onSchemeChange $scope, newVal

    $scope.scope = $scope

    console.log 'scope', $scope

    $scope.addPremise = addPremise

    $scope.deletePremise = deletePremise

  )

  .controller('ArgumentEditCtrl', ($scope, $stateParams, $translate, project, theory, projectInfo, statements) ->
    $scope.title = $translate.instant 'projects.editargument'
    $scope.statements = statements.query $stateParams
    $scope.argument = argumentedit.get $stateParams, ->
      onArgumentRetrieve $scope
    $scope.theory = theory.get {
      pid: $stateParams.pid,
      db: $stateParams.db,
      tpid: projectInfo.getSchemesProject(project),
      tid: projectInfo.getSchemesName(project)
    }

    $scope.$watch 'schemeId', (newVal) ->
      onSchemeChange $scope, newVal

    $scope.scope = $scope

    $scope.addPremise = addPremise

    $scope.deletePremise = deletePremise

    $scope.onSave = () ->
      console.log 'argument', $scope.argument
      #argumentedit.update $stateParams, $scope.argument
  )
