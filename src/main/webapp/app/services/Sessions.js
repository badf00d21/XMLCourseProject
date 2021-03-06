/**
 * Created by Aleksandar Lukić on 19.5.16.
 */


(function (angular) {
    'use strict';

    angular.module('app.Sessions', [])

        .factory('Sessions', ['$http', function ($http) {

            return {

                getFinished: function () {
                    return  $http({
                        method: 'GET',
                        url: 'api/sessions',
                        params: {
                            status: 'finished'
                        }
                    });
                },

                getUpcoming: function () {
                    return  $http({
                        method: 'GET',
                        url: 'api/sessions',
                        params: {
                            status: 'upcoming'
                        }
                    });
                },

                create: function (data) {

                    var startDate =  data.beginDate.toISOString();
                    var endDate =  data.endDate.toISOString();
                    
                    return $http({
                        method: 'POST',
                        url: 'api/sessions',
                        data: {
                            session: {
                                _xmlns : "http://ftn.uns.ac.rs/xml",
                                '_xmlns:xsi': "http://www.w3.org/2001/XMLSchema-instance",
                                _beginDate : startDate,
                                _endDate : endDate,
                                place: data.place
                            }
                        }
                    });
                }
            };
        }]);

}(angular));
