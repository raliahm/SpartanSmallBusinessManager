-- phpMyAdmin SQL Dump
-- version 5.2.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 09, 2025 at 03:16 AM
-- Server version: 8.0.39
-- PHP Version: 8.2.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ssbmDB`
--

-- --------------------------------------------------------

--
-- Table structure for table `businesses`
--

CREATE TABLE `businesses` (
  `business_id` int NOT NULL,
  `business_description` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `business_name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `logo_url` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `provider_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `businesses`
--

INSERT INTO `businesses` (`business_id`, `business_description`, `business_name`, `logo_url`, `provider_id`) VALUES
(3, 'best used cellphones', 'Popstreet', '/uploads/1746723029587_4dcece00-d659-452f-927a-f046473551e3-2.png', 3);

-- --------------------------------------------------------

--
-- Table structure for table `events`
--

CREATE TABLE `events` (
  `event_id` int NOT NULL,
  `event_date` date DEFAULT NULL,
  `event_description` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `event_location` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `event_name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `provider_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `events`
--

INSERT INTO `events` (`event_id`, `event_date`, `event_description`, `event_location`, `event_name`, `provider_id`) VALUES
(1, '2025-05-15', 'In person shopping experience', 'UNCG EUC building', 'Pop Up shop', 3),
(2, '2025-05-16', 'nunndun', 'ncjnjdnd', 'nsjnjdbjd', 3);

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `product_id` int NOT NULL,
  `product_category` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `product_description` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `product_image` longtext COLLATE utf8mb4_general_ci,
  `product_name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `product_price` double NOT NULL,
  `product_quantity` int NOT NULL,
  `business_id` int NOT NULL,
  `provider_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`product_id`, `product_category`, `product_description`, `product_image`, `product_name`, `product_price`, `product_quantity`, `business_id`, `provider_id`) VALUES
(2, 'Technology', 'silver', '/uploads/64068b4b-da21-4fd7-b263-5a581c9fa4be.jpeg', 'Iphone 11 pro', 999, 23, 3, 3),
(3, 'Technology', 'red', '/uploads/e02d310e-f6ab-4fc2-9019-9b9a6a25538f.jpeg', 'iphone 11', 699, 45, 3, 3),
(4, 'Technology', 'red, 128gb', '/uploads/9c0ffe88-d716-43df-a7a5-36d45af29932.png', 'Iphone 14 plus', 500, 23, 3, 3);

-- --------------------------------------------------------

--
-- Table structure for table `providers`
--

CREATE TABLE `providers` (
  `provider_id` int NOT NULL,
  `created_at` date DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `provider_name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `username` varchar(255) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `providers`
--

INSERT INTO `providers` (`provider_id`, `created_at`, `email`, `password`, `provider_name`, `username`) VALUES
(1, '2025-05-08', 'test@email.com', 'hello', 'Test One', 'test'),
(2, '2025-05-08', 'mike@email.com', 'hello2020', 'mike j', 'mike'),
(3, '2025-05-08', 'jane@email.com', 'hello', 'Jane', 'jane'),
(4, '2025-05-08', 'xnss@email.com', 'nsjns', 'sxsx', 'scdced'),
(5, '2025-05-08', 'nsjnsnnsij@gmail.com', ' jndjnjnxjns', ' sbshbsjn', ' sjnjsnjnsuj');

-- --------------------------------------------------------

--
-- Table structure for table `reviews`
--

CREATE TABLE `reviews` (
  `review_id` int NOT NULL,
  `review_content` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `product_id` int NOT NULL,
  `provider_id` int NOT NULL,
  `reply_content` text COLLATE utf8mb4_general_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reviews`
--

INSERT INTO `reviews` (`review_id`, `review_content`, `product_id`, `provider_id`, `reply_content`) VALUES
(1, 'Absolutely love this item. Will buy again!', 2, 3, 'Thank you'),
(2, 'Item arrived damaged. Disappointed.', 2, 3, NULL),
(3, 'Great value for the price.', 3, 3, NULL),
(4, 'Not bad, but shipping was slow.', 3, 3, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `statistics`
--

CREATE TABLE `statistics` (
  `stats_id` int NOT NULL,
  `total_reviews` int NOT NULL,
  `total_sales` double NOT NULL,
  `provider_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `statistics`
--

INSERT INTO `statistics` (`stats_id`, `total_reviews`, `total_sales`, `provider_id`) VALUES
(1, 12, 5000, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `businesses`
--
ALTER TABLE `businesses`
  ADD PRIMARY KEY (`business_id`),
  ADD KEY `FKf1894fqus275bjypaochkywu1` (`provider_id`);

--
-- Indexes for table `events`
--
ALTER TABLE `events`
  ADD PRIMARY KEY (`event_id`),
  ADD KEY `FKfhjoyv2sam2as93p5df3lb9rn` (`provider_id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`product_id`),
  ADD KEY `FKi65q12p725kxcn1jcosg2x9y4` (`business_id`),
  ADD KEY `FKtltawi3myjt9pi09219eiou1o` (`provider_id`);

--
-- Indexes for table `providers`
--
ALTER TABLE `providers`
  ADD PRIMARY KEY (`provider_id`),
  ADD UNIQUE KEY `UK7ant8u8y5lel5bd0d6hdexmde` (`email`),
  ADD UNIQUE KEY `UK3922mjbrjd3u8ve5dfl0q2tpv` (`username`);

--
-- Indexes for table `reviews`
--
ALTER TABLE `reviews`
  ADD PRIMARY KEY (`review_id`),
  ADD KEY `FKpl51cejpw4gy5swfar8br9ngi` (`product_id`),
  ADD KEY `FKrsomnwai2734u8lqdqu5yd96x` (`provider_id`);

--
-- Indexes for table `statistics`
--
ALTER TABLE `statistics`
  ADD PRIMARY KEY (`stats_id`),
  ADD KEY `FKoqrkrbxm558xetarw1kigdapx` (`provider_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `businesses`
--
ALTER TABLE `businesses`
  MODIFY `business_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `events`
--
ALTER TABLE `events`
  MODIFY `event_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `product_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `providers`
--
ALTER TABLE `providers`
  MODIFY `provider_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `reviews`
--
ALTER TABLE `reviews`
  MODIFY `review_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `statistics`
--
ALTER TABLE `statistics`
  MODIFY `stats_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `businesses`
--
ALTER TABLE `businesses`
  ADD CONSTRAINT `FKf1894fqus275bjypaochkywu1` FOREIGN KEY (`provider_id`) REFERENCES `providers` (`provider_id`);

--
-- Constraints for table `events`
--
ALTER TABLE `events`
  ADD CONSTRAINT `FKfhjoyv2sam2as93p5df3lb9rn` FOREIGN KEY (`provider_id`) REFERENCES `providers` (`provider_id`);

--
-- Constraints for table `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `FKi65q12p725kxcn1jcosg2x9y4` FOREIGN KEY (`business_id`) REFERENCES `businesses` (`business_id`),
  ADD CONSTRAINT `FKtltawi3myjt9pi09219eiou1o` FOREIGN KEY (`provider_id`) REFERENCES `providers` (`provider_id`);

--
-- Constraints for table `reviews`
--
ALTER TABLE `reviews`
  ADD CONSTRAINT `FKpl51cejpw4gy5swfar8br9ngi` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`),
  ADD CONSTRAINT `FKrsomnwai2734u8lqdqu5yd96x` FOREIGN KEY (`provider_id`) REFERENCES `providers` (`provider_id`);

--
-- Constraints for table `statistics`
--
ALTER TABLE `statistics`
  ADD CONSTRAINT `FKoqrkrbxm558xetarw1kigdapx` FOREIGN KEY (`provider_id`) REFERENCES `providers` (`provider_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
