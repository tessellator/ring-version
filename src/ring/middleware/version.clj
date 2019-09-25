(ns ring.middleware.version
  (:require [ring.util.response :as resp]))

(gen-class
 :name ring.middleware.version.Version
 :methods [])

(defn- implementation-version []
  (try
    (-> ring.middleware.version.Version
        .getPackage
        .getImplementationVersion)
    (catch Exception _
      "dev")))

(defn wrap-version-response
  "A middleware that adds the ImplementationVersion from the jar manifest to an
  X-Version header. Returns 'dev' if no appropriate version is found (such as
  when running at the REPL)."
  [handler]
  (let [version (implementation-version)]
    (fn [request]
      (-> request
          handler
          (resp/header "X-Version" version)))))
