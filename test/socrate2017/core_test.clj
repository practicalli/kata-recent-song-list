(ns socrate2017.core-test
  (:require [clojure.test :refer :all]
            [socrate2017.core :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 1 1))))

;; (def song)
;; (def songs [])

(deftest get-song-list-test
  (testing "get empty recent song list"
    (is
     (= [] recent-songs)))
  (testing "check recent songs is empty"
    (is
     (empty? recent-songs))))

(deftest adding-songs-test
  (testing "add song returns a song list with entries"
    (is
     (not (empty?
              (add-song "Barry Manilow - Love on the rocks" recent-songs))))))

  (testing "add multiple song returns a song list with entries"
    (is
     (not (empty?
           (->> recent-songs
             (add-song "Barry Manilow - Love on the rocks")
             (add-song "Phil Colins - Sususudio" )))))))


(deftest recently-added-song-first-test

  (testing "most recent song should be first in the list when empty list"
    (is (=
         (first (add-song "Daft Punk - Get Lucky" recent-songs))
         "Daft Punk - Get Lucky")))

