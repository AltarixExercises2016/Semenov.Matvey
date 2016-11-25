# VK messager application

Семенов Матвей

Курсы андроид-разработчиков, Altarix, 2016-2017
 


## Цель

Создать простой месенджер для VK.com

## Задачи

### Экран авторизации

Web view в котором открыто окно авторизации вк.ком, через это окно получается токен для сеанса пользователя и запоминается в шаредпреференс, затем активити убивается и при повторном запуске проверяется есть ли в шаредпреференс токен, если есть то открывается экран списка диалогов, если нет, то экран авторизации.

### Экран списка диалогов

Список активных диалогов (чатов) с людьми (иконка диалога, название диалога(беседы), последнее сообщение, время последней записи, количество не прочитанных сообщений. При нажатии на диалог открывается список сообщений. При нажатии на фотку человека открывается его профиль.

В заголовке название экрана (Dialogs) и кнопка - настроек (шестеренка), нажатие открывает активити с настройками.

### Экран чата

Последние сообщения чата в виде списка, в заголовке сообщений имя человека и его иконка, при нажатии на иконку открывается его профиль.

edit text с кнопкой отправки, нажатие кнопки - отправка текста написанного в edit text.

Свайп списка снизу вверх обновляет список (1), свайп списка сверху вниз подгружает более старые сообщения, заменяя собой новые.

В заголовке название чата (или имя человека) и кнопка обновления, нажатие выполняет ту же функцию как и (1).

### Экран настроек

#### 3 свитча настроек: 

+ Отвечает за статус "Быть онлайн"

+ вкл - будут грузиться фото в приложении, выкл - не будут грузиться фотки в приложении (заместо них в чате будет написано слово "photo")

+ вкл - будут грузиться иконки людей, выкл - место для иконок не будет пустым, оно освободит место для остальной информации в сообщении

настройки записываются в шаредпреференс

Внизу кнопка LOGOUT - закрывает все активити, стирает токен из шаредпреференс, запускает экран авторизации

### Экран пользователя

В левом верхнем углу фото человека, нажатие на которое открывает активити с view pager в котором будут лежать фрагменты, в которых будут фото пользователя из профиля, которые можно будет масштабировать.

Внизу кнопка "Send message", нажатие открывает экран чата с этим человеком.

Остальное пространство заполнено информацией о пользователе (город, возраст, имя, в сети или нет, страну, где учился и др.)

### База данных

Будет хранить информацию о пользователях (обновляемая во время последнего обновления информации в приложении) и последние сообщения с ними

### Реализация вложений в сообщениях

+ Аудио:
название мелодии, кнопка старт мелодии, кнопка паузы, кнопка стоп (отличается от паузы тем что отматывает мелодии на ноль), кнопки промотки музыки вперед и назад на 5 сек.

+ Видео:
Превью фотка в самом сообщении, при нажатии на которую открывается проигрыватель в бразуере.

+ Фото: 
Фотка в превью виде, при нажатии на которую открывается масштабируемая фотка максимального разрешения.

+ Документ:
Отображаются с иконкой документа и названием документа, нажатие на которую открывает бразуер.

+ Стикер: 
см. пункт Фото, но без возможности открыть больший размер.

+ Ссылка:
текст приплюсовывается к сообщению пользователя и подсвечивается синим цветом, нажатие на текст ссылки открывает браузер с этой ссылкой.

+ Пересланые сообщения:
надпись пересланые сообщения синим цветом, нажатие на надпись открывает в текущем окне список пересланых сообщений, кнопка назад должна вернуть к предыдущему списку (согласно тому порядку в котором открывалось).
