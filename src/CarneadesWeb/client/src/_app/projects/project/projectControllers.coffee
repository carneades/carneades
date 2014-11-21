# Copyright (c) 2014 Fraunhofer Gesellschaft
# This Source Code Form is subject to the terms of the Mozilla Public
# License, v. 2.0. If a copy of the MPL was not distributed with this
# file, You can obtain one at http://mozilla.org/MPL/2.0/.

define [
  'angular'
], (angular) ->
  extend = (object, properties) ->
    for key, val of properties
      object[key] = val
    return object

  return angular.module('project.controllers', [])

  .controller 'ProjectViewCtrl', ($scope, $stateParams, $state, $translate,
    $location, $previousState, project) ->
    $scope.$state.$current.self.tooltip = project.title
    $stateParams.db = 'main'

    _newArgumentGraph = ->
      $state.go 'home.projects.project.new', pid: project.id, reload: true
      $previousState.memo 'newArgumentGraphEditor'

    _copyLink = () ->
      lnk = [
        $location.protocol()
        "://"
        $location.host()
        ":"
        $location.port()
        "/carneades"
        $scope.$state.href 'home.projects.project'
      ].join ''
      window.prompt(
        "Copy to clipboard: Ctrl+C, Enter",
        lnk,
        pid: project.id
      )

    $scope = extend $scope,
      project: project
      newArgumentGraph: _newArgumentGraph
      copyLink: _copyLink
      tooltipNew: $translate.instant 'tooltip.argumentgraph.new'

    return @

  .controller 'ProjectNewArgGraphCtrl', ($scope, $state, $cnBucket,
    $stateParams, $translate, Project, breadcrumbService, editorService) ->

    ag =
      name: ""
      header:
        description:
          en: ""
          de: ""
          fr: ""
          it: ""
          sp: ""
          nl: ""
        title: ""

    _onSave = () ->
      _description = {}
      for k, v of $scope.ag.header.description
        _description[k] = editor.htmlize v

      $scope.ag.header.description = _description
      project = {
        name: $scope.ag.name
        title: $scope.ag.title
        header: $scope.ag.header
      }

      Project.newArgumentGraph(
        {pid: $stateParams.pid},
        project
      ).$promise.then((data) ->
        $cnBucket.remove $state.$current
        state = $previousState.get 'newArgumentGraphEditor'
        params = pid: $stateParams.pid, db: $scope.ag.name
        $state.go state.state.name, params, reload: true
        $previousState.forget 'newArgumentGraphEditor'
      )

    $scope = extend $scope,
      ag: ag
      languages: editorService.getLanguages()
      onSave: _onSave
      onCancel: -> editorService.onCancel 'newArgumentGraphEditor'
      placeholderName: $translate.instant 'placeholder.name'
      placeholderTitle: $translate.instant 'placeholder.title'
      tooltipSave: $translate.instant 'tooltip.argumentgraph.save'
      tooltipCancel: $translate.instant 'tooltip.cancel'

    return @

  .controller 'ProjectEditCtrl', ($scope, $state, $previousState,
    $stateParams, $translate, $cnBucket, metadata, Metadata,
    editorService) ->
    _onSave = ->
      params = pid: $stateParams.pid, db: 'main', mid: 1

      # no put implemented yet
      Metadata.update(params, metadata).$promise.then((data) ->
        $cnBucket.remove $state.$current
        state = $previousState.get 'newMetadataEditor'
        $state.go state.state.name, state.params, reload: true
        $previousState.forget 'newMetadataEditor'
      )

    $scope = extend $scope,
      metadata: metadata
      languages: editorService.getLanguages()
      onSave: _onSave
      onCancel: -> editorService.onCancel 'newMetadataEditor'
      tooltipSave: $translate.instant 'tooltip.ag.save'
      tooltipCancel: $translate.instant 'tooltip.cancel'

    return @
