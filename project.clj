(defproject invoice-api "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :main invoice-api.handler
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [compojure "1.6.1"]
                 [ring/ring-defaults "0.3.2"]
                 [ring/ring-jetty-adapter "1.9.5"]]
  :plugins [[lein-ring "0.12.5"]]
  :ring {:handler invoice-api.handler/app}
  :profiles
  ;; {:uberjar {:aot :all}
   {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.2"]]}})
