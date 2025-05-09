-- customers.sql

-- Customers
INSERT INTO `customers`(`cust_id`, `created_date`, `cust_address`, `cust_city`, `cust_country`, `cust_email`, `cust_name`, `cust_password`, `cust_phone`, `cust_state`, `cust_username`, `cust_zip`, `restricted`, `role`, `state`) VALUES
(1, '2024-05-01', '123 Maple St', 'Raleigh', 'USA', 'alice@example.com', 'Alice Johnson', 'pass123', '555-1234', 'Pending', 'alicej', '27601', 0, 2, 'Pending'),
(2, '2024-05-02', '456 Oak Ave', 'Durham', 'USA', 'bob@example.com', 'Bob Smith', 'secret', '555-2345', 'Approved', 'bobsmith', '27701', 0, 2, 'Approved'),
(3, '2024-05-03', '789 Pine Rd', 'Charlotte', 'USA', 'carol@example.com', 'Carol Lee', 'mypwd', '555-3456', 'Rejected', 'carollee', '28202', 0, 2, 'Rejected'),
(4, '2024-05-04', '101 Cedar Blvd', 'Greensboro', 'USA', 'dan@example.com', 'Dan Miller', 'letmein', '555-4567', 'Pending', 'danm', '27401', 0, 2, 'Pending'),
(5, '2024-05-05', '202 Birch Dr', 'Wilmington', 'USA', 'eve@example.com', 'Eve Davis', '123456', '555-5678', 'Approved', 'eved', '28401', 0, 2, 'Approved'),
(6, '2024-05-06', '303 Ash Ln', 'Fayetteville', 'USA', 'frank@example.com', 'Frank Brown', 'qwerty', '555-6789', 'Pending', 'frankb', '28301', 0, 2, 'Pending'),
(7, '2024-05-07', '404 Spruce Ct', 'Cary', 'USA', 'grace@example.com', 'Grace Wilson', 'abc123', '555-7890', 'Rejected', 'gracew', '27511', 0, 2, 'Rejected'),
(8, '2024-05-08', '505 Elm St', 'Asheville', 'USA', 'henry@example.com', 'Henry Clark', 'passw0rd', '555-8901', 'Approved', 'henryc', '28801', 0, 2, 'Approved'),
(9, '2024-05-09', '606 Fir Ave', 'Chapel Hill', 'USA', 'irene@example.com', 'Irene Lewis', 'testpass', '555-9012', 'Pending', 'irenel', '27514', 0, 2, 'Pending'),
(10, '2024-05-10', '707 Walnut Pl', 'Winston-Salem', 'USA', 'jack@example.com', 'Jack Walker', 'ilovecats', '555-0123', 'Approved', 'jackw', '27101', 0, 2, 'Approved');

-- Provider Users
INSERT INTO `provider_users`(`provider_id`, `created_date`, `provider_name`, `provider_user_address`, `provider_user_city`, `provider_user_country`, `provider_user_email`, `provider_user_password`, `provider_user_phone`, `provider_user_state`, `provider_user_zip`, `provider_username`, `restricted`, `role`, `state`) VALUES
(1, '2024-05-01', 'HealthOne', '12 First Ave', 'Raleigh', 'USA', 'contact@healthone.com', 'h1pass', '555-1001', 'Pending', '27601', 'healthone', 0, 3, 'Pending'),
(2, '2024-05-02', 'MediCorp', '34 Second St', 'Durham', 'USA', 'support@medicorp.com', 'mcpass', '555-1002', 'Approved', '27701', 'medicorp', 0, 3, 'Approved'),
(3, '2024-05-03', 'WellLife', '56 Third Blvd', 'Charlotte', 'USA', 'info@welllife.com', 'wlpass', '555-1003', 'Rejected', '28202', 'welllife', 0, 3, 'Rejected'),
(4, '2024-05-04', 'CarePlus', '78 Fourth Dr', 'Greensboro', 'USA', 'care@careplus.com', 'cppass', '555-1004', 'Pending', '27401', 'careplus', 0, 3, 'Pending'),
(5, '2024-05-05', 'VitalHealth', '90 Fifth Ln', 'Wilmington', 'USA', 'help@vitalhealth.com', 'vhpass', '555-1005', 'Approved', '28401', 'vitalhealth', 0, 3, 'Approved'),
(6, '2024-05-06', 'WellSpring', '11 Sixth Ct', 'Fayetteville', 'USA', 'admin@wellspring.com', 'wspass', '555-1006', 'Pending', '28301', 'wellspring', 0, 3, 'Pending'),
(7, '2024-05-07', 'UnityCare', '22 Seventh Rd', 'Cary', 'USA', 'team@unitycare.com', 'ucpass', '555-1007', 'Rejected', '27511', 'unitycare', 0, 3, 'Rejected'),
(8, '2024-05-08', 'BrightHealth', '33 Eighth St', 'Asheville', 'USA', 'connect@brighthealth.com', 'bhpass', '555-1008', 'Approved', '28801', 'brighthealth', 0, 3, 'Approved'),
(9, '2024-05-09', 'TrueWellness', '44 Ninth Ave', 'Chapel Hill', 'USA', 'hello@truewellness.com', 'twpass', '555-1009', 'Pending', '27514', 'truewellness', 0, 3, 'Pending'),
(10, '2024-05-10', 'PureCare', '55 Tenth Pl', 'Winston-Salem', 'USA', 'info@purecare.com', 'pcpass', '555-1010', 'Approved', '27101', 'purecare', 0, 3, 'Approved');

-- Businesses
INSERT INTO `businesses`(`business_id`, `business_address`, `business_description`, `business_name`, `category`, `restricted`, `status`, `provider_id`) VALUES
(1, '101 Maple St, Raleigh, NC', 'Local family clinic providing general care.', 'Maple Family Clinic', 'Healthcare', 0, 'Pending', 1),
(2, '202 Oak Rd, Durham, NC', 'Dental services with pediatric specialization.', 'Oak Dental Center', 'Dental', 0, 'Pending', 2),
(3, '303 Pine Ave, Charlotte, NC', 'Therapy and counseling for all ages.', 'Pine Therapy Hub', 'Mental Health', 0, 'Pending', 3),
(4, '404 Birch Ln, Cary, NC', 'Physiotherapy and injury rehab services.', 'Birch Physical Therapy', 'Rehabilitation', 0, 'Pending', 4),
(5, '505 Cedar Blvd, Greensboro, NC', '24/7 emergency medical clinic.', 'Cedar Urgent Care', 'Emergency Care', 0, 'Pending', 5),
(6, '606 Walnut St, Asheville, NC', 'Nutritional consultation and wellness plans.', 'Walnut Wellness Center', 'Nutrition', 0, 'Pending', 6),
(7, '707 Hickory Way, Winston-Salem, NC', 'Support groups and grief counseling.', 'Hickory Hope Services', 'Mental Health', 0, 'Pending', 7),
(8, '808 Sycamore Ct, Wilmington, NC', 'Chiropractic and spinal health services.', 'Sycamore Spine Clinic', 'Chiropractic', 0, 'Pending', 8),
(9, '909 Redwood Pl, Chapel Hill, NC', 'Prenatal and maternal healthcare services.', 'Redwood Women’s Health', 'Obstetrics', 0, 'Pending', 9),
(10, '1001 Dogwood Cir, Fayetteville, NC', 'Occupational therapy for children.', 'Dogwood Therapy Group', 'Pediatrics', 0, 'Pending', 10);

-- Events
INSERT INTO `events`(`event_id`, `created_date`, `event_date`, `event_description`, `event_location`, `event_name`, `provider_id`) VALUES
(1, '2025-04-01', '2025-05-15', 'Free dental checkups and hygiene tips.', 'Oak Dental Center, Durham, NC', 'Dental Health Fair', 2),
(2, '2025-04-02', '2025-06-10', 'Mental wellness seminar for teens.', 'Pine Therapy Hub, Charlotte, NC', 'Teen Talk: Mental Health Awareness', 3),
(3, '2025-04-05', '2025-05-20', 'Nutrition workshop with free consultations.', 'Walnut Wellness Center, Asheville, NC', 'Eat Well, Live Well', 6),
(4, '2025-04-07', '2025-07-05', 'Spinal health education and posture screening.', 'Sycamore Spine Clinic, Wilmington, NC', 'Straighten Up!', 8),
(5, '2025-04-09', '2025-05-30', 'Pediatric care awareness for new parents.', 'Dogwood Therapy Group, Fayetteville, NC', 'Caring for Little Ones', 10),
(6, '2025-04-11', '2025-06-12', 'Stress relief and mindfulness session.', 'Hickory Hope Services, Winston-Salem, NC', 'Mind Matters', 7),
(7, '2025-04-13', '2025-06-25', 'Basic CPR and first aid training.', 'Cedar Urgent Care, Greensboro, NC', 'Save a Life', 5),
(8, '2025-04-15', '2025-05-18', 'Therapeutic yoga and recovery class.', 'Birch Physical Therapy, Cary, NC', 'Stretch and Heal', 4),
(9, '2025-04-18', '2025-06-01', 'Prenatal care education for expecting mothers.', 'Redwood Women’s Health, Chapel Hill, NC', 'Healthy Pregnancy 101', 9),
(10, '2025-04-20', '2025-05-22', 'General wellness day with guest doctors.', 'Maple Family Clinic, Raleigh, NC', 'Family Wellness Expo', 1);

-- Products
INSERT INTO `products`(`product_id`, `product_category`, `product_description`, `product_name`, `product_price`, `product_quantity`, `business_id`, `provider_id`) VALUES
(1, 'Cupcakes', 'Delicious chocolate cupcake topped with rich frosting', 'Chocolate Cupcake', 2.99, 100, 11, 11),
(2, 'Cupcakes', 'Classic vanilla cupcake with creamy vanilla frosting', 'Vanilla Cupcake', 2.49, 120, 11, 11),
(3, 'Cupcakes', 'Red velvet cupcake with a cream cheese frosting swirl', 'Red Velvet Cupcake', 3.49, 90, 11, 11),
(4, 'Cupcakes', 'Lemon cupcake with tangy lemon frosting', 'Lemon Cupcake', 2.79, 110, 11, 11),
(5, 'Cupcakes', 'Strawberry-filled cupcake with strawberry frosting', 'Strawberry Cupcake', 3.29, 100, 11, 11),
(6, 'Cupcakes', 'Rich and moist carrot cake cupcake with cream cheese frosting', 'Carrot Cake Cupcake', 3.19, 85, 11, 11),
(7, 'Cupcakes', 'Chocolate mint cupcake with mint frosting', 'Chocolate Mint Cupcake', 3.49, 95, 11, 11),
(8, 'Cupcakes', 'S’mores cupcake with marshmallow frosting', 'S’mores Cupcake', 3.69, 80, 11, 11),
(9, 'Cupcakes', 'Mocha cupcake with coffee-flavored frosting', 'Mocha Cupcake', 3.19, 100, 11, 11),
(10, 'Cupcakes', 'Peanut butter cupcake with chocolate frosting', 'Peanut Butter Cupcake', 3.59, 75, 11, 11);

-- Bad Words
INSERT INTO `bad-words`(`id`, `word`) VALUES
(1, 'anal'), (2, 'anus'), (3, 'arse'), (4, 'ass'), (5, 'ballsack'), (6, 'balls'), (7, 'bastard'), (8, 'bitch'),
(9, 'biatch'), (10, 'bloody'), (11, 'blowjob'), (12, 'blow job'), (13, 'bollock'), (14, 'bollok'), (15, 'boner'),
(16, 'boob'), (17, 'bugger'), (18, 'bum'), (19, 'butt'), (20, 'buttplug'), (21, 'clitoris'), (22, 'cock'),
(23, 'coon'), (24, 'crap'), (25, 'cunt'), (26, 'damn'), (27, 'dick'), (28, 'dildo'), (29, 'dyke'), (30, 'fag'),
(31, 'feck'), (32, 'fellate'), (33, 'fellatio'), (34, 'felching'), (35, 'fuck'), (36, 'f u c k'), (37, 'fudgepacker'),
(38, 'fudge packer'), (39, 'flange'), (40, 'Goddamn'), (41, 'God damn'), (42, 'hell'), (43, 'homo'), (44, 'jerk'),
(45, 'jizz'), (46, 'knobend'), (47, 'knob end'), (48, 'labia'), (49, 'lmao'), (50, 'lmfao'), (51, 'muff'), (52, 'nigger'),
(53, 'nigga'), (54, 'omg'), (55, 'penis'), (56, 'piss'), (57, 'poop'), (58, 'prick'), (59, 'pube'), (60, 'pussy'),
(61, 'queer'), (62, 'scrotum'), (63, 'sex'), (64, 'shit'), (65, 's hit'), (66, 'sh1t'), (67, 'slut'), (68, 'smegma'),
(69, 'spunk'), (70, 'tit'), (71, 'tosser'), (72, 'turd'), (73, 'twat'), (74, 'vagina'), (75, 'wank'), (76, 'whore'),
(77, 'wtf');

-- Reviews
INSERT INTO `reviews`(`review_id`, `created_date`, `review_content`, `product_id`, `provider_id`, `flagged`, `customer_id`) VALUES
(1, '2025-05-08 12:00:00', 'These cupcakes are absolute crap! The frosting was too sweet, and the texture was all wrong. Worst purchase ever!', 1, 1, TRUE, 1),
(2, '2025-05-08 12:05:00', 'The cupcakes were alright, but the ballsack design on them was unnecessary. Maybe focus on taste more?', 2, 2, TRUE, 2),
(3, '2025-05-08 12:10:00', 'Goddamn, these cupcakes are delicious! Definitely coming back for more, especially the chocolate ones!', 3, 3, FALSE, 3),
(4, '2025-05-08 12:15:00', 'This cupcake was total bullshit. It was dry and the frosting tasted awful. Don’t waste your money.', 4, 4, TRUE, 304),
(5, '2025-05-08 12:20:00', 'I feel like such a prick for spending so much on these cupcakes. They didn’t taste fresh at all.', 5, 5, TRUE, 305),
(6, '2025-05-08 12:25:00', 'These cupcakes are a little too much for me. The flavor was alright, but I couldn’t finish one.', 6, 6, TRUE, 306),
(7, '2025-05-08 12:30:00', 'I really enjoyed the cupcakes! They were light and fluffy, and the frosting was on point. I’m definitely coming back!', 7, 7, FALSE, 7),
(8, '2025-05-08 12:35:00', 'Not the best cupcakes I’ve had, but they weren’t bad either. The cupcakes were kind of average.', 8, 8, FALSE, 8),
(9, '2025-05-08 12:40:00', 'I was so excited to try these cupcakes, but I felt like an idiot for spending so much. Not worth it.', 9, 9, TRUE, 9),
(10, '2025-05-08 12:45:00', 'These cupcakes are fucking amazing! Best I’ve ever had! Perfect amount of sweetness and fluffiness.', 10, 10, FALSE, 10);
