# ring-version

A ring middleware that populates `X-Version` header on a response.

## Usage

```clojure
(require '[ring.middleware.version :refer [wrap-version]])

(def handler
  (-> my-routes
      (wrap-version "1.0")))
```

This function also provides a function `implementation-version` that extracts
the ImplementationVersion from a jar file given a type and a default value.

```clojure
(require '[ring.middleware.version :refer [implementation-version wrap-version]])

(def handler
  (-> my-routes
      (wrap-version (implementation-version my.Type "dev"))))
```

### License

Copyright © 2019 Thomas C. Taylor and contributors.

Distributed under the Eclipse Public License, the same as Clojure.