;; Copyright (c) 2012 Fraunhofer Gesellschaft
;; This Source Code Form is subject to the terms of the Mozilla Public
;; License, v. 2.0. If a copy of the MPL was not distributed with this
;; file, You can obtain one at http://mozilla.org/MPL/2.0/.

(ns carneades.web.modules.common.dialog.utils
  (:use clojure.pprint
        carneades.engine.dublin-core
        carneades.database.import
        carneades.database.export
        carneades.engine.uuid)
  (:import java.io.File)
  (:require [carneades.database.db :as db]
            [carneades.database.argument-graph :as ag-db]))

(def ^{:dynamic true} *debug* true)

(require 'carneades.database.argument-graph)
;; (def swank-con swank.core.connection/*current-connection*)

;; (defmacro break []
;;   `(binding [swank.core.connection/*current-connection* swank-con]
;;      (swank.core/break)))


(let [repl-out *out*]
  (defn log [msg & vals]
    (binding [*out* repl-out]
      (let [line (apply format msg vals)]
        (println line)))))

(defn store-ag
  "Stores ag into a DB and returns the dbname"
  [project ag]
 (let [dbname (str "db-" (make-uuid))
        ;; TODO: changes the pass
       root "root"
       passwd "pw1"
       dbconn (db/make-connection project dbname root passwd)]
    (prn "dbname =" dbname)
    (ag-db/create-argument-database project dbname root passwd (make-metadata))
    (import-from-argument-graph dbconn ag true)
    dbname))

(defn load-ag
  [dbname]
  ;; TODO: changes the pass
  (let [db (db/make-connection dbname "root" "pw1")]
    (export-to-argument-graph db)))


;; (defmacro with-timeout [millis & body]
;;   `(let [future# (future ~@body)]
;;      (try
;;        (.get future# ~millis java.util.concurrent.TimeUnit/MILLISECONDS)
;;        (catch Exception x# 
;;          (do
;;            (future-cancel future#)
;;            nil)))))
