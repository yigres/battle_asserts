(ns battle-asserts.issues.segregate-even-and-odd-numbers
  (:require [clojure.test.check.generators :as gen]
            [faker.generate :as faker]))

(def level :easy)

(def description "Напишите функцию, принимающую на вход массив.
                 Результатом выполнения функции является массив в котором все четные элементы
                 из входного массива находятся в начале а нечетные в конце")

(defn arguments-generator []
  (gen/tuple (gen/vector gen/int)))

(def test-data
  [{:expected [12 34 8 90 45 9 3]
    :arguments [[12 34 45 9 8 90 3]]}
   {:expected [44 54 14 48 1 7 51 23 25 41]
    :arguments [[1 7 44 51 54 14 23 25 48 41]]}
   {:expected [2 4 1 3 5]
    :arguments [[1 2 3 4 5]]}
   {:expected [2 4 8 6 5 9 3]
    :arguments [[2 4 5 9 3 8 6]]}])

(defn solution [array]
  (concat (filter even? array)
          (filter odd? array)))