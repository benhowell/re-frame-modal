(ns subscribers
  (:require
   [re-frame.core :refer [reg-sub-raw]])
  (:require-macros [reagent.ratom :refer [reaction]]))

(reg-sub-raw
 :modal
 (fn [db _] (reaction (:modal @db))))
