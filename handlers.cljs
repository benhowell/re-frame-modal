(ns handlers
  (:require
   [re-frame.core :refer [reg-event-db reg-event-fx path dispatch]]))

(reg-event-db
 :modal
 (fn [db [_ data]]
   (assoc-in db [:modal] data)))
