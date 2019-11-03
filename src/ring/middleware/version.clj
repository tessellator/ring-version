(ns ring.middleware.version
  (:require [ring.util.response :as response]))

(defn wrap-version-header [handler version]
  (fn [request]
    (-> (handler request)
        (response/header "X-Version" version))))

(defn implementation-version
  ([type]
   (implementation-version type nil))
  ([type default]
   (try
     (or (-> type
             .getPackage
             .getImplementationVersion)
         default)
     (catch Exception _
       default))))
