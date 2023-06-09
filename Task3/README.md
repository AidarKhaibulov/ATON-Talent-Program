# ЗАДАНИЕ 3

Задание 2.
Представим на время, что вы black hat, и у вас в распоряжении оказались данные ~30 млн. заказов некоторого сервиса
доставки еды за некоторый период 2021 и 2022 года.
Поверхностный анализ показал, что данные содержат 18 758 328 уникальных телефонов с полным именем клиента, а
средняя длина полного имени - 20 символов (латинских или кириллических).
Допустим, вы хотите развернуть веб-сервис, который позволит по номеру телефона найти полное имя клиента. Но вы не
хотите оставлять следы на диске или в базе данных - придется все держать в памяти. Но еще вы не хотите зря тратить
крипту на слишком большой сервер.
Поэтому давайте оценим, сколько памяти займут эти данные:

 если мы хотим реализовать поиск за постоянное время, т.е. O(1)?

 если мы хотим занять как можно меньше памяти?

Самое главное - объяснить, как вы пришли к той или иной числовой оценке.
Можно выбрать любой язык программирования/платформу

## Выбор структуры данных
Так как вводится условие - поиск за константное время - мы неизбежно сталкиваемся с необходимостью
использовать хеш-таблицы, поскольку только эта структура предоставляет возможность поиска за постоянное время.
## Решение коллизий
Среди 30млн данных с ключами-телефонами только 19 млн уникальных, это означает, что мы не сможем 
заполнить таблицу без коллизий. У нас есть два варианта - быстрый и эффективный по памяти.
Быстрый вариант подразумевает использование открытой адресации для разрешения коллизий,
а именно - метод двойного хеширования. Второй вариант подразумевает использование метода
цепочек, в таком случае мы задействуем как можно меньше памяти.

#### Быстрый вариант
Если мы хотим чтобы поиск стабильно работал за время **O(1)**, следует проследить за тем, 
чтобы коэффициент заполнения таблицы равнялся 0.5, и чтобы размер таблицы был простым числом
(в этом случае последовательность проб рано или поздно проверит все ячейки). В таком случае
поиск не деградирует до линейного. Нам нужен размер таблицы в 30млн*2=60млн. 
Берем ближайшее просто число - 60 000 011 - такой размер таблицы нам понадобиться, чтобы выполнить
первое условие.

#### Эффективный по памяти вариант
Если мы воспользуемся методом цепочек, то не будет необходимости хранить таблицу в 60млн, 
так как при этом способе коэффициент заполнения вполне может быть >=1. В таком случае 
неуникальные ключи просто будут складываться в списки, и скорость поиска перестанет быть
константной, но станет зависеть от размерности этих списков. В таком случае мы сможем просто
создать таблицу на 30 млн.

# Ответ на первый вопрос
Номер телефона - long (8 байт) + 20 символов имени по 2 байта, итого 48 байта. Плюс на каждую ссылку
потребуется 4 байта и 8 байт оверхеда. Получаем 60 байт, что не кратно 8, поэтому округлится до 64 байт.
Столько будет занимать один объект в нашей базе. Размер таблицы - 60 000 011 + 4 байта на массив.
Получаем, что 3 840 000 708 байт или 3.8 ГБ в памяти потребуется для выполнения этой задачи.

# Ответ на второй вопрос
В данном варианте нам хватит таблицы размерностью в 30 млн. Итого 1 920 000 000 или 1.9 ГБ.
Столько потребуется места в памяти, но поиск будет медленнее, чем за постоянное время.