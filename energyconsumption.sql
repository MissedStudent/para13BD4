-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Время создания: Окт 12 2024 г., 10:29
-- Версия сервера: 8.0.24
-- Версия PHP: 8.0.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `energyconsumption`
--

-- --------------------------------------------------------

--
-- Структура таблицы `accounts`
--

CREATE TABLE `accounts` (
  `id_account` int NOT NULL,
  `account_number` int NOT NULL,
  `consumer_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Дамп данных таблицы `accounts`
--

INSERT INTO `accounts` (`id_account`, `account_number`, `consumer_id`) VALUES
(1, 45000, 1),
(2, 35000, 2),
(5, 50000, 3);

-- --------------------------------------------------------

--
-- Структура таблицы `consumers`
--

CREATE TABLE `consumers` (
  `id_consumer` int NOT NULL,
  `consumer_name` text NOT NULL,
  `consumer_need` int NOT NULL,
  `consumer_date_expire` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Дамп данных таблицы `consumers`
--

INSERT INTO `consumers` (`id_consumer`, `consumer_name`, `consumer_need`, `consumer_date_expire`) VALUES
(1, 'Можайское шоссе,44', 600, '2024-10-31'),
(2, 'Союзная,5', 450, '2024-10-29'),
(3, 'дом', 30000, '2024-11-02');

-- --------------------------------------------------------

--
-- Структура таблицы `devices`
--

CREATE TABLE `devices` (
  `id_devices` int NOT NULL,
  `device_name` text NOT NULL,
  `consumer_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Дамп данных таблицы `devices`
--

INSERT INTO `devices` (`id_devices`, `device_name`, `consumer_id`) VALUES
(1, 'пылесос', 1),
(2, 'холодильник', 2),
(3, 'микроволновка', 3);

-- --------------------------------------------------------

--
-- Структура таблицы `indications`
--

CREATE TABLE `indications` (
  `id_indication` int NOT NULL,
  `indication_number` int NOT NULL,
  `account_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Дамп данных таблицы `indications`
--

INSERT INTO `indications` (`id_indication`, `indication_number`, `account_id`) VALUES
(1, 350, 1),
(2, 300, 2),
(3, 45000, 3);

-- --------------------------------------------------------

--
-- Структура таблицы `resources`
--

CREATE TABLE `resources` (
  `id_resource` int NOT NULL,
  `resource_amount` int NOT NULL,
  `consumer_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Дамп данных таблицы `resources`
--

INSERT INTO `resources` (`id_resource`, `resource_amount`, `consumer_id`) VALUES
(1, 50000, 1),
(2, 45000, 2),
(3, 999999, 3);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`id_account`);

--
-- Индексы таблицы `consumers`
--
ALTER TABLE `consumers`
  ADD PRIMARY KEY (`id_consumer`);

--
-- Индексы таблицы `devices`
--
ALTER TABLE `devices`
  ADD PRIMARY KEY (`id_devices`);

--
-- Индексы таблицы `indications`
--
ALTER TABLE `indications`
  ADD PRIMARY KEY (`id_indication`);

--
-- Индексы таблицы `resources`
--
ALTER TABLE `resources`
  ADD PRIMARY KEY (`id_resource`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `accounts`
--
ALTER TABLE `accounts`
  MODIFY `id_account` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT для таблицы `consumers`
--
ALTER TABLE `consumers`
  MODIFY `id_consumer` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT для таблицы `devices`
--
ALTER TABLE `devices`
  MODIFY `id_devices` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT для таблицы `indications`
--
ALTER TABLE `indications`
  MODIFY `id_indication` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT для таблицы `resources`
--
ALTER TABLE `resources`
  MODIFY `id_resource` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
