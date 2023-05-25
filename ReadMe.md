# Тестирование Web-сайта МТС Банка
## Десктопные тест-кейсы:
### Тест-кейс "Оформление карты MTS CASHBACK":
1) Перейти на сайт https://www.mtsbank.ru/
2) Нажать на кнопку "Узнать лимит"
3) Проверить под полями "Номер телефона" и "Серия и номер паспорта" надпись "Обязательное поле"
-------------
4) Ввести в поле "Номер телефона" - "1"
5) Проверить под полем надпись "Введите верные цифры"
6) Ввести в поле "Серия и номер паспорта" - "0"
7) Проверить под полем надпись "Введите верные серию и номер паспорта"
-------------
8) Ввести "Рандомные" цифры в поля "Номер телефона" и "Серия и номер паспорта"
9) Нажать на кнопку "Узнать лимит"
10) Проверить появившееся поле с надписью "Код из СМС" и поля для 4 цифр
11) Вести рандомный код в "Код из СМС"
12) Проверить надпись под полем "Неправильный код"


### Тест-кейс "Оформление вклада":
1) Перейти на сайт https://www.mtsbank.ru/
2) Перейти во вкладку "Вклады и счета"
3) Ввести в поле "Сумма вклада" значение " "
4) Проверить, что в поле "Сумма вклада" осталось значение "1 000 ₽"
-------------
5) Ввести в поле "Сумма вклада" значение "1000000000000000"
6) Проверить, что в поле "Сумма вклада" осталось значение "50 000 000 ₽"
-------------
7) Ввести в поле "Срок вклада" значение "1000"
8) Проверить, что значение стало "36 месяцев"
-------------
9) Ввести в поле "Срок вклада" значение " "
10) Проверить, что значение стало "3 месяца"
-------------
11) Ввести в поле "Срок вклада" значение "22"
12) Проверить, что значение стало "24 месяца"
-------------
13) Нажать на цифру под полем "18"
14) Проверить, что значение стало "18 месяцев"
-------------
15) Нажать на "Хочу пополнять" и "Открыть онлайн"
16) Запомнить в переменные "Ставка", "Доход по вкладу", "Сумма в конце срока" первого предложения
17) Нажать "Открыть" первого продукта
18) На странице вклада ввести значения "Сумма вклада" - "50 000 000", "Срок вклада" - "18 месяцев"
19) Поставить галочку "Хочу ежемесячно капитализировать проценты"
20) Проверить "Ставку", "Доход по вкладу", "Сумма в конце срока"
-------------
21) Нажать "Оформить онлайн"
22) Нажать кнопку "Отправить"
23) Проверить, что под полями есть надписи "Укажите фамилию, имя и отчество контактного лица","Введите верный номер телефона","Выберите ваш населенный пункт", "Выберите офис"
-------------
24) Ввести в поле "ФИО" - "0"
25) Проверить надпись под полем "Используйте только кириллицу"
26) Ввести в поле "ФИО" - "Petr Petrov"
27) Проверить надпись под полем "Используйте только кириллицу"
-------------
28) Ввести в поле "ФИО" - "П"
29) Проверить надпись под полем "Укажите фамилию, имя и отчество"
-------------
30) Ввести в поле "Мобильный телефон" - "1"
31) Проверить надпись "Введите верный номер телефона"
-------------
32) Ввести в поле "ФИО" - "П П"
33) Ввести в поле "Мобильный телефон" рандомные значения
34) Нажать на поле "Город" и выбрать "Амурск"
35) Нажать на поле "Офис" и выбрать "Дополнительный офис № 25"
36) Нажать кнопку "Отправить"
37) Проверить окошко с заголовком "Заявка принята"


### Тест-кейс "Оформление кредита":
1) Зайти на сайт https://www.mtsbank.ru/
2) Перейти во вкладку "Кредиты"
3) Нажать на кнопку "Оформить онлайн" 
4) Нажать кнопку "Далее"
5) Проверить надписи обязательности заполнения полей у "Цель кредита", "ФИО", "Дата рождения", "Мобильный телефон"
-------------
6) Ввести в поле "ФИО" - "."
7) Проверить надпись под полем "Используйте только кириллицу"
8) Ввести в поле "ФИО" - "0"
9) Проверить надпись под полем "Используйте только кириллицу"
10) Ввести в поле "ФИО" - "Petr Petrov"
11) Проверить надпись под полем "Используйте только кириллицу"
-------------
12) Ввести в поле "ФИО" - "Ааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааа бббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббб"
13) Проверить надпись под полем "Не более 255 символов"
-------------
14) Ввести в поле "Дата рождения" - "сегодняшяя дата "-" 80 лет"
15) Проверить надпись под полем "Возраст клиента должен быть не более 70 лет"
-------------
16) Ввести в поле "Дата рождения" - "сегодняшяя дата "-" 2 года"
17) Проверить надпись под полем "Возраст клиента должен быть не менее 20 лет"
-------------
18) Ввести в поле "Электронная почта" - "0"
19) Проверить надпись "Введите верный электронный адрес"
-------------
20) Убрать галочку "Я согласен с условиями рассмотрения заявки"
21) Проверить надпись "Для подачи заявки необходимо дать согласие на этот пункт"
-------------
22) Ввести в поле "Сумма" - " "
23) Проверить, что в поле "Сумма" появилось значение "20 000 ₽"
-------------
24) Ввести в поле "Сумма" - "100000000000"
25) Проверить, что в поле "Сумма" появилось значение "5 000 000 ₽"
-------------
26) Ввести в поле "Срок" - " "
27) Проверить, что в поле "Срок" появилось значение "12 месяцев"
-------------
28) Ввести в поле "Срок" - "100"
29) Проверить, что в поле "Срок" появилось значение "60 месяцев"
-------------
30) Ввести в поле "Мобильный телефон" - "1"
31) Проверить надпись "Введите верный номер телефона"
-------------
32) Ввести в поле "Дата рождения" - "сегодняшяя дата "-" 20 лет"
33) Ввести в поле "ФИО" - "Иван Иванов"
34) Выбрать "Цель кредита" - "Автомобиль"
35) Ввести в поле "Электронная почта" - "Иван@м.р"
36) Ввести в поле "Мобильный телефон" рандомные значения
37) Нажать "Далее"
38) Вести рандомный код в "Код из СМС"
49) Проверить надпись "Неправильный код"


### Тест-кейс "Оформление расчётного счета для малого бизнеса":
1) Зайти на сайт https://www.mtsbank.ru/
2) Перейти во вкладку "Малый бизнес и ИП"
3) Перейти в раздел "Расчётный счёт"
4) Нажать на кнопку "Открыть счет"
5) Нажать на кнопку "Отправить заявку"
6) Проверить  надписи обязательности заполнения полей у "Мобильный телефон", "Электронная почта", "ИНН", "Название организации", "Организационно-правовая форма", "Контактное лицо"
-------------
7) Ввести в поле "Мобильный телефон" - "1"
8) Проверить надпись "Введите верный номер телефона"
-------------
9) Ввести в поле электронная почта "1"
10) Проверить надпись "Введите верный эл. адрес"
11) Ввести в поле электронная почта "Иван Иванович@m.r"
12) Проверить надпись "Введите верный эл. адрес"
-------------
13) Ввести в поле "ИНН" - " "
14) Проверить надпись "ИНН некорректный, проверьте правильность написания"
-------------
15) Убрать галочку "Я ознакомлен и согласен с условиями обработки персональных данных"
16) Проверить надпись "Для обработки вашей заявки вы должны согласиться с условиями обработки персональных данных"
-------------
17) Ввести в "Контактное лицо" значение "0"
18) Проверить надпись "Используйте только кириллицу"
19) Ввести в поле "ФИО" - "Petr Petrov"
20) Проверить надпись под полем "Используйте только кириллицу"
-------------
21) Ввести в поле "ФИО" - "П"
22) Проверить надпись под полем "Фамилия и имя обязательны для заполнения"
-------------
23) Ввести в "Контактное лицо" значение "Вввввввввввввввввввввввввввввввввввввввввввввввввввввввввввв вввв"
24) Проверить надпись "Максимальная длина фамилии 50 символов"
-------------
25) Ввести в "Контактное лицо" значение "Вввввввввввввввввввввввввввввввввввв аааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааавввв"
26) Проверить надпись "Максимальная длина имени 50 символов"
-------------
27) Ввести в "Контактное лицо" значение "Вввввввввввввввввввввввввввввввввввв ааааа ааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааавввв"
28) Проверить надпись "Максимальная длина отчества 50 символов"
-------------
29) Ввести в поле "Мобильный телефон" рандомные значения
30) Ввести в поле электронная почта "ИванИванович@m.r"
31) Ввести в поле "ИНН" - "окей"
32) Проверить, что поле "Название организации" заполнилось "О`КЕЙ", поле "Организационно-правовая форма" - "ООО"
33) Ввести в "Контактное лицо" значение "Иван Иванов"
34) Нажать кнопку "Отправить заявку"
35) Проверить появившееся поле "Код из СМС"
36) Вести рандомный код в "Код из СМС"
37) Проверить надпись "Неправильный код"


## Мобильные тест-кейсы:
### Тест-кейс "Оформление карты MTS CASHBACK":
1) Перейти на сайт https://www.mtsbank.ru/
2) Подтвердить регион "Москва"
3) Нажать на кнопку "Узнать лимит"
4) Проверить, что под полями "Номер телефона" и "Серия и номер паспорта" появилась надпись "Обязательное поле"
-------------
5) Ввести в поле "Номер телефона" - "1"
6) Проверить, что под полем появилась надпись "Введите верные цифры"
7) Ввести в поле "Серия и номер паспорта" - "0"
8) Проверить, что под полем появилась надпись "Введите верные серию и номер паспорта"
-------------
9) Ввести "Рандомные" цифры в поля "Номер телефона" и "Серия и номер паспорта"
10) Нажать на кнопку "Узнать лимит"
11) Вести рандомный код в "Код из СМС"
1) Проверить появление надписи пол полем для цифр "Неправильный код"


### Тест-кейс "Вход в личный кабинет":
1) Перейти на сайт https://www.mtsbank.ru/
2) Подтвердить регион "Москва"
3) Нажать кнопку "Войти"
4) Ввести в поле телефона "1"
5) Проверить, что под полем появилась надпись "Номер телефона должен содержать 10 цифр, например, +7 912 345-67-89"
-------------
6) Ввести в поле телефона "1111111111"
7) Проверить, что под полем появилась надпись "Неправильный номер телефона"
-------------
8) Ввести "Рандомный номер телефона"
9) Нажать на кнопку "Далее"
10) Вести рандомный код в "Код из СМС"
11) Проверить, что под полем появилась надпись "Неверный код"