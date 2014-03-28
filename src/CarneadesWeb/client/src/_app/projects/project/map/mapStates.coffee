# Copyright (c) 2014 Fraunhofer Gesellschaft
# This Source Code Form is subject to the terms of the Mozilla Public
# License, v. 2.0. If a copy of the MPL was not distributed with this
# file, You can obtain one at http://mozilla.org/MPL/2.0/.

  define ['angular'], (angular) ->
  angular.module('map.states', ["map.controllers"])
  .config(($stateProvider) ->
    states = [
      name: "home.projects.project.map"
      label: "Map"
      url: "/:db/map"
      commands: [
        label: "Outline"
        state: "home.projects.project.outline"
      ,
        label: "Theory"
        state: "home.projects.project.theory"
      ]
      views:
        "@":
          template: "<bc-navigation></bc-navigation>"
        "content@":
          templateUrl: "project/map/map.tpl.html"
          controller: "MapCtrl"
          resolve:
            map: ($http, $stateParams, $location) ->
              $http(
                method: 'GET'
                url: $location.protocol() + "://" + $location.host() + ":" + $location.port() + "/carneades/api/projects/#{$stateParams.pid}/#{$stateParams.db}/map"
              ).then (data) -> data.data
    ]

    angular.forEach states, (state) -> $stateProvider.state state
  )