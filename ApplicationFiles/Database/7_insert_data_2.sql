
INSERT INTO exercise(name, createddate, type) VALUES ('Bài tập nghe 1', CURRENT_TIMESTAMP, 'listening');
INSERT INTO exercise(name, createddate, type) VALUES ('Bài tập đọc 1', CURRENT_TIMESTAMP, 'reading');


INSERT INTO exercisequestion
(image, audio, question, option1, option2, option3, option4, correctanswer, createddate, exerciseid)
VALUES ('exercise/image_1.jpg', 'exercise/audio_1.mp3', 'Look at the picture and listen to the sentences in the Part 1 TOEIC Test. Choose the sentence that best describes the picture:',
        'A', 'B', 'C', 'D', 'A', CURRENT_TIMESTAMP, 1);
INSERT INTO exercisequestion
(image, audio, question, option1, option2, option3, option4, correctanswer, createddate, exerciseid)
VALUES ('exercise/image_2.jpg', 'exercise/audio_2.mp3', 'Look at the picture and listen to the sentences in the Part 1 TOEIC Test. Choose the sentence that best describes the picture:',
        'A', 'B', 'C', 'D', 'B', CURRENT_TIMESTAMP, 1);
INSERT INTO exercisequestion
(image, audio, question, option1, option2, option3, option4, correctanswer, createddate, exerciseid)
VALUES ('exercise/image_3.jpg', 'exercise/audio_3.mp3', 'Look at the picture and listen to the sentences in the Part 1 TOEIC Test. Choose the sentence that best describes the picture:',
        'A', 'B', 'C', 'D', 'C', CURRENT_TIMESTAMP, 1);
INSERT INTO exercisequestion
(image, audio, question, option1, option2, option3, option4, correctanswer, createddate, exerciseid)
VALUES ('exercise/image_4.jpg', 'exercise/audio_4.mp3', 'Look at the picture and listen to the sentences in the Part 1 TOEIC Test. Choose the sentence that best describes the picture:',
        'A', 'B', 'C', 'D', 'D', CURRENT_TIMESTAMP, 1);

INSERT INTO exercisequestion(question, option1, option2, option3, option4, correctanswer, createddate, exerciseid)
VALUES ('I dont think he will remember the appointment you remind him.','so', 'if', 'unless', 'lest', 'C', CURRENT_TIMESTAMP, 2);

INSERT INTO exercisequestion(question, option1, option2, option3, option4, correctanswer, createddate, exerciseid)
VALUES ('The river has overflowed his banks _____ it has been raining continuously for several days.','still', 'yet', 'when', 'as', 'D', CURRENT_TIMESTAMP, 2);

INSERT INTO exercisequestion(question, option1, option2, option3, option4, correctanswer, createddate, exerciseid)
VALUES ('Those village folk are poor _____ they always seem so contented.','still', 'yet', 'when', 'as', 'C', CURRENT_TIMESTAMP, 2);

INSERT INTO exercisequestion(question, option1, option2, option3, option4, correctanswer, createddate, exerciseid)
VALUES ('he was not interested in music, he agreed to go to the concert.','still', 'yet', 'when', 'as', 'A', CURRENT_TIMESTAMP, 2);





