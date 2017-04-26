# re-frame-modal
Basic [re-frame](https://github.com/Day8/re-frame) recipe for creating modal/dialog/overlay panels. This implementation is pure re-frame and css, free from jQuery and DOM manipulation and can be used as a drop-in replacement for [Bootstrap modals](http://getbootstrap.com/javascript/#modals) (minus all that jQuery cruft).


![Screeno](https://github.com/benhowell/re-frame-modal/blob/296794b3e008490b4bc69794dfba3d218b21e90c/bootstrap-modal.png)



## Usage

Add the css file (adjusting paths to suit) to the head of your file
```cljs
[:head
 ;; other head stuff ...
 (include-css "/re-frame-modal.css")]
```

NOTE: You can inline these styles if you don't wish to have the fade-in animations.

-------------------------------

Add the [dispatch handler](https://github.com/benhowell/re-frame-modal/blob/master/handlers.cljs#L5) and the [subscriber](https://github.com/benhowell/re-frame-modal/blob/master/subscribers.cljs#L6) to your own handlers and subscribers accordingly.

Add the modal component to your page. Personally, I choose to do this just once in core.cljs straight after app mount (resulting in a global modal container), but you can do it at the component level instead if you wish.

```cljs
(ns core
 (:require
  [modal :as modal]))

(defn render-view [view]
 [:div
  [modal/modal] view]
```

-------------------------------


Use it!

```cljs
(defn my-awesome-modal-fn []
 [:button
  {:title "Click to show modal!"
   :on-click #(dispatch [:modal {:show? true
                                 :child [modal/hello]
                                 :size :small}])} "Show me the modal!"]
```

If you want to use bootstrap style modals, then include bootstrap css file (no need for the js file).

```cljs
(defn my-awesome-bootstrap-modal-fn []
 [:button
  {:class "btn btn-xs btn-primary" 
   :title "Click to show modal!"
   :on-click #(dispatch [:modal {:show? true
                                 :child [modal/hello-bootstrap]
                                 :size :small}])} "Bootstrap my modal!"]
```

-------------------------------


## Options
re-frame-modal takes the following parameters (set with dispatch event):
 * `show?` (boolean): Required. Shows modal
 * `child` (hiccup | func): Required. Hiccup or a function returning hiccup containing the modal panel to display.
 * `size` (keyword): Optional. The size of the modal. Options are
   * `:extra-small` (15% width)
   * `:small` (30% width)
   * `:large` (70% width)
   * `:extra-large` (85% width).
   * If no size parameter given, defaults to 50% width.


------------------------------


