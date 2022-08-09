(ns invoice-api.controllers.invoices
  (:require [config.db.core :refer [get-invoices get-invoice-by-id]]))

(defn index
  []
  (str (get-invoices)))

(defn show
  [id]
  (str (get-invoice-by-id id)))
