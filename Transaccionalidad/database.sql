CREATE TABLE public.balances
(
    id integer NOT NULL,
    person_name varchar NOT NULL,
    balance real NOT NULL,
    CONSTRAINT balances_pkey PRIMARY KEY (id)
);

INSERT INTO public.balances(id, person_name, balance) VALUES (1, 'Julio', 0);
INSERT INTO public.balances(id, person_name, balance) VALUES (2, 'Juan', 5000);