(ns ring.middleware.version-test
  (:require [clojure.test :refer :all]
            [ring.middleware.version :refer [wrap-version]]
            [ring.mock.request :as mock]
            [ring.util.response :refer [response]]))

(deftest test-wrap-version
  (let [handler (wrap-version (constantly (response "")) "0.1.0")
        request (mock/request :get "/")
        response (handler request)]
    (is (= "0.1.0"
           (get-in response [:headers "X-Version"])))))
