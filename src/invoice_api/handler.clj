(ns invoice-api.handler
  (:gen-class)
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.adapter.jetty :refer [run-jetty]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [invoice-api.controllers.invoices :as invoices]))

(defroutes site
  (GET "/invoices" [] (invoices/index))
  (GET "/invoices/:id{[0-9]+}" [id] (invoices/show id))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults site site-defaults))

(defn -main 
  []
  (run-jetty app {:host "0.0.0.0" :port 3000}))