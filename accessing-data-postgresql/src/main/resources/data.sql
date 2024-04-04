/*INSERT INTO public."user" (id, email, "name")
VALUES (3, 'lala', 'lala'),
       (4, 'land', 'land');*/


/*INSERT INTO public."user" (email, "name")
VALUES (1. 'pippo', 'baudo'),
       (2. 'pippo', 'caruso');
*/
INSERT INTO public."user" (id, email, "name")
VALUES (1, 'pippo', 'baudo'),
       (2, 'pippo', 'caruso')
ON CONFLICT (id)
DO NOTHING;

INSERT INTO public."user_items" (id, user_id, "title")
VALUES (1, 1, 'item1'),
       (2, 1, 'item2'),
       (3, 2, 'item2-1'),
       (4, 2, 'item2-2'),
       (5, 2, 'item2-3')
    ON CONFLICT (id)
DO NOTHING;
