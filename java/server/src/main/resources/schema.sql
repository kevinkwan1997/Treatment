DROP TABLE IF EXISTS difficulties, goals, goals_difficulties, rewards, goals_rewards CASCADE;

START TRANSACTION;

-- CREATING DIFFICULTIES TABLE
CREATE TABLE difficulties(
        difficulty_id           serial,
        difficulty              varChar(16) NOT NULL,
        
        CONSTRAINT pk_difficulty_id PRIMARY KEY(difficulty_id)
);

INSERT INTO difficulties (difficulty) VALUES ('Easy');
INSERT INTO difficulties (difficulty) VALUES ('Medium');
INSERT INTO difficulties (difficulty) VALUES ('High');

-- CREATING GOALS TABLE
CREATE TABLE goals(
        goal_id                 serial, 
        goal_name               varchar(256) NOT NULL,
        goal_desc               varchar(256) NOT NULL,
        
        CONSTRAINT pk_goal_id PRIMARY KEY(goal_id)
);
INSERT INTO goals(goal_name, goal_desc) VALUES ('Finish App', 'Finish making an application');
INSERT INTO goals(goal_name, goal_desc) VALUES ('Really Do It', 'Actually finish this app');
INSERT INTO goals(goal_name, goal_desc) VALUES ('Please', 'Finish making an application');

-- CREATING GOALS_DIFFICULTIES TABLE
CREATE TABLE goals_difficulties(
        goal_id                 int NOT NULL,
        difficulty_id           int NOT NULL,
        
        CONSTRAINT pk_goal_difficulties PRIMARY KEY (goal_id, difficulty_id),
        CONSTRAINT fk_goal_difficulties_goal FOREIGN KEY (goal_id) REFERENCES goals(goal_id),
        CONSTRAINT fk_goal_difficulties_difficulty FOREIGN KEY (difficulty_id) REFERENCES difficulties(difficulty_id)
);

INSERT INTO goals_difficulties (goal_id, difficulty_id) VALUES (1, 3);
INSERT INTO goals_difficulties (goal_id, difficulty_id) VALUES (2, 3);
INSERT INTO goals_difficulties (goal_id, difficulty_id) VALUES (3, 2);



-- CREATING THE REWARDS TABLE
CREATE TABLE rewards(
        reward_id               serial,
        reward                  varchar(256),
        price                   decimal(12, 2),
        
        CONSTRAINT pk_reward_id PRIMARY KEY(reward_id)
);

INSERT INTO rewards (reward, price) VALUES ('VR set', 300.00);
INSERT INTO rewards (reward, price) VALUES ('Thicker Mattress', 400.00);
INSERT INTO rewards (reward, price) VALUES ('Order Sushi Fish', 80.50);
INSERT INTO rewards (reward, price) VALUES ('Crab Legs', 120.00);
INSERT INTO rewards (reward, price) VALUES ('Bass Guitar', 500.00);
INSERT INTO rewards (reward, price) VALUES ('Full Keyboard', 100.00);




-- CREATING GOALS_REWARDS TABLE
CREATE TABLE goals_rewards(
        goal_id                 int NOT NULL,
        reward_id               int NOT NULL,
                
        CONSTRAINT pk_goal_reward PRIMARY KEY (goal_id, reward_id),
        CONSTRAINT fk_goal_reward_goal FOREIGN KEY (goal_id) REFERENCES goals(goal_id),
        CONSTRAINT fk_goal_reward_reward FOREIGN KEY (reward_id) REFERENCES rewards(reward_id)
);

INSERT INTO goals_rewards VALUES (1, 6);
INSERT INTO goals_rewards VALUES (2, 3);
INSERT INTO goals_rewards VALUES (3, 1);

SELECT * FROM difficulties;
SELECT * FROM goals;
SELECT * FROM goals_difficulties;
SELECT * FROM rewards;
SELECT * FROM goals_rewards;

-- return goal by reward ID
SELECT goal_name FROM goals g
JOIN goals_rewards gr ON g.goal_id = gr.goal_id
JOIN rewards r ON gr.reward_id = r.reward_id
WHERE r.reward_id = 1; 

-- return reward by goal difficulty
SELECT reward FROM rewards r 
JOIN goals_rewards gr ON r.reward_id = gr.reward_id
JOIN goals g ON gr.goal_id = g.goal_id
JOIN goals_difficulties gd ON g.goal_id = gd.goal_id
JOIN difficulties d ON gd.difficulty_id = d.difficulty_id
WHERE d.difficulty_id = 3;


--ROLLBACK;



END TRANSACTION;