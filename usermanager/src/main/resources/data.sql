INSERT INTO usermanager.users (id, mail, username)
VALUES (1, 'pippo@topolinia.com', 'pippobaudo')
ON CONFLICT (id) DO NOTHING;

INSERT INTO usermanager.users (id, mail, username)
VALUES (2, 'paperino@topolinia.com', 'paolinopaperino')
ON CONFLICT (id) DO NOTHING;

INSERT INTO usermanager.users (id, mail, username)
VALUES (2, 'minnie@topolinia.com', 'minnielabelle')
    ON CONFLICT (id) DO NOTHING;

INSERT INTO usermanager.roles (id, name)
VALUES (1, 'ROLE_USER')
    ON CONFLICT (id) DO NOTHING;

INSERT INTO usermanager.roles (id, name)
VALUES (2, 'ROLE_SUPPORT')
    ON CONFLICT (id) DO NOTHING;

