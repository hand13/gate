(ns clotest.core
  (:use [org.httpkit.server :only [run-server]]
        [ring.util.response :only [response]]))

(defn handler [request]
  (println (:remote-addr request))
  (response "hello world"))
(defn -main [& args]
  (run-server handler {:port 5000})
  (println "start http kit on port 5000")
  )
