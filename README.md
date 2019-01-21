# ring-version

ring-version provides a ring middleware `wrap-version-response` to add an 
`X-Version` header to every response. The version used is determined by the
Implementation-Version set in the manifest. If no value is found (such as when
you are running at a REPL), a value of `dev` is used.


### License

Copyright © 2019 Thomas C. Taylor and contributors.

Distributed under the Eclipse Public License, the same as Clojure.