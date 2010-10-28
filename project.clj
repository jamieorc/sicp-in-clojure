(defproject sicp-in-clojure "0.0.1"
  :description "SICP exercises in Clojure"
  :dependencies [[org.clojure/clojure "1.2.0"]
                 [org.clojure/clojure-contrib "1.2.0"]]
  :dev-dependencies [[swank-clojure "1.2.1"]
		     [ring/ring-jetty-adapter "0.2.6"]]
  :jvm-opts ["-Xmx256m"])
