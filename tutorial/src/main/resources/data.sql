
INSERT INTO public."tutorials" (id, title, description, published)
VALUES (1, 'Corriere', 'Della Sera', true),
       (2, 'Giornale', 'Del Mese', true)
ON CONFLICT (id)
DO NOTHING;

INSERT INTO public."comments" (id, content, tutorial_id)
VALUES (1, "Rivoluzione in atto", 1),
       (2, "Rivoluzione terminata", 2),
       (3, "Topolino fedifrago", 1),
       (4, "Pippo Fedele", 1),
       (5, "Paperino Scemo", 2)
    ON CONFLICT (id)
DO NOTHING;
