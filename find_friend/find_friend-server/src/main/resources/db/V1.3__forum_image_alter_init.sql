ALTER TABLE forum DROP COLUMN image;
CREATE TABLE forum_image (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           forum_id INT,
                           image_path VARCHAR(255),
                           create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
                           create_user VARCHAR(255)
);
