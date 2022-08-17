(ns invoice-api.controllers.invoices
  (:require [clojure.java.io :as io]
            [config.db.core :refer [get-invoice-by-id get-invoices]]
            [selmer.parser :as template]))

(->
 "./src/templates/invoices"
 (io/as-file)
 (.getAbsolutePath)
 (template/set-resource-path!))

(defn invoices-view [invoices]
  (let [invoice {}]
    (->> invoices
         (map #(assoc invoice
                      :code (:invoices/code %)
                      :id (:invoices/id %)
                      :title (:invoices/title %)
                      :date (:invoices/timestamp %))))))

(defn index
  []
  (let [invoices (get-invoices)]
    (template/render-file "index.html" {:invoices (invoices-view invoices)})))

(defn show
  [id]
  (str (get-invoice-by-id id)))
