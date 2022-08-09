(ns config.db.core
  (:require [next.jdbc :as jdbc]
            [honey.sql :as sql]))

(def db-config
  {:dbtype "postgresql"
   :dbname "invoice_api_dev"
   :host "localhost"
   :user "aristotelescosta"
   :password "postgres"})

(def conn (jdbc/get-datasource db-config))


(jdbc/execute! conn ["select * from invoices"])

(defn get-invoices 
  []
  (-> {:select [:*]
       :from [:invoices]}
      (#(jdbc/execute! conn (sql/format %)))))

(defn get-invoice-by-id
  [id]
  (-> {:select [:*]
       :from [:invoices]
       :where [:= :invoices.id (Integer/parseInt id)]}
      (#(jdbc/execute! conn (sql/format %)))))
