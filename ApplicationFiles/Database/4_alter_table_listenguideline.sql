ALTER TABLE listenguideline MODIFY COLUMN title VARCHAR(512) NOT NULL;
ALTER TABLE listenguideline MODIFY COLUMN content TEXT NOT NULL;
ALTER TABLE listenguideline MODIFY COLUMN createddate TIMESTAMP NOT NULL;


ALTER TABLE listenguideline ADD UNIQUE (title);

UPDATE listenguideline SET image = 'Java-Framework.png' WHERE listenguidelineid =1;
UPDATE listenguideline SET image = 'Java-Framework.png' WHERE listenguidelineid =2;
ALTER TABLE listenguideline MODIFY COLUMN image VARCHAR(255) NOT NULL;