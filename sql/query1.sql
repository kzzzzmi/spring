INSERT INTO
	user_mst(
		id,
		username,
		PASSWORD,
		NAME,
		email,
		create_date,
		update_date
	)
VALUES(
	0,
	'jaemin4',
	'1234',
	'김재민',
	'kzzzzmi@naver.com',
	NOW(),
	NOW()
);

SELECT
	*
FROM
	user_mst um
	LEFT OUTER JOIN user_mst um2 ON(um2.id = um.id)
WHERE
	um.username = 'jaemin';
	#PASSWORD = '1234';