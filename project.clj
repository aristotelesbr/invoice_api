(defproject invoice-api "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :main invoice-api.handler
  :migratus {:store :database
             :migration-dir "migrations"
             :db {:classname "org.postgresql.Driver"
                  :subprotocol "postgresql"
                  :subname "//localhost:5432/invoices_api_dev"
                  :user "aristotelescosta"
                  :password "postgres"}}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [compojure "1.6.1"]
                 [migratus "1.3.5"]
                 [org.postgresql/postgresql "42.1.4"]
                 [ring/ring-defaults "0.3.2"]
                 [ring/ring-jetty-adapter "1.9.5"]
                 [com.github.seancorfield/honeysql "2.2.858"]
                 [com.github.seancorfield/next.jdbc "1.2.796"]
                 [selmer "1.12.53"]]
  :plugins [[lein-ring "0.12.6"]
            [migratus-lein "0.7.3"]]
  :ring {:handler invoice-api.handler/app}
  :profiles
   {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                         [ring/ring-mock "0.3.2"]]}})
