--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.1
-- Dumped by pg_dump version 9.5.1

-- Started on 2016-07-16 17:45:10 PDT

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 8 (class 2615 OID 15397567)
-- Name: skillmatch; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA skillmatch;


ALTER SCHEMA skillmatch OWNER TO postgres;

SET search_path = skillmatch, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 187 (class 1259 OID 15397592)
-- Name: address; Type: TABLE; Schema: skillmatch; Owner: postgres
--

CREATE TABLE address (
    id integer NOT NULL,
    street character varying NOT NULL,
    number character varying,
    po_box character varying,
    line_extra character varying
);


ALTER TABLE address OWNER TO postgres;

--
-- TOC entry 186 (class 1259 OID 15397590)
-- Name: address_id_seq; Type: SEQUENCE; Schema: skillmatch; Owner: postgres
--

CREATE SEQUENCE address_id_seq
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;


ALTER TABLE address_id_seq OWNER TO postgres;

--
-- TOC entry 2456 (class 0 OID 0)
-- Dependencies: 186
-- Name: address_id_seq; Type: SEQUENCE OWNED BY; Schema: skillmatch; Owner: postgres
--

ALTER SEQUENCE address_id_seq OWNED BY address.id;


--
-- TOC entry 189 (class 1259 OID 15397604)
-- Name: catalog; Type: TABLE; Schema: skillmatch; Owner: postgres
--

CREATE TABLE catalog (
    id integer NOT NULL,
    text character varying,
    parent_id integer
);


ALTER TABLE catalog OWNER TO postgres;

--
-- TOC entry 188 (class 1259 OID 15397602)
-- Name: catalog_id_seq; Type: SEQUENCE; Schema: skillmatch; Owner: postgres
--

CREATE SEQUENCE catalog_id_seq
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;


ALTER TABLE catalog_id_seq OWNER TO postgres;

--
-- TOC entry 2457 (class 0 OID 0)
-- Dependencies: 188
-- Name: catalog_id_seq; Type: SEQUENCE OWNED BY; Schema: skillmatch; Owner: postgres
--

ALTER SEQUENCE catalog_id_seq OWNED BY catalog.id;


--
-- TOC entry 185 (class 1259 OID 15397581)
-- Name: contact; Type: TABLE; Schema: skillmatch; Owner: postgres
--

CREATE TABLE contact (
    id integer NOT NULL,
    user_id integer NOT NULL,
    contact_type_id integer NOT NULL,
    contact_type_value character varying
);


ALTER TABLE contact OWNER TO postgres;

--
-- TOC entry 184 (class 1259 OID 15397579)
-- Name: contact_id_seq; Type: SEQUENCE; Schema: skillmatch; Owner: postgres
--

CREATE SEQUENCE contact_id_seq
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;


ALTER TABLE contact_id_seq OWNER TO postgres;

--
-- TOC entry 2458 (class 0 OID 0)
-- Dependencies: 184
-- Name: contact_id_seq; Type: SEQUENCE OWNED BY; Schema: skillmatch; Owner: postgres
--

ALTER SEQUENCE contact_id_seq OWNED BY contact.id;


--
-- TOC entry 191 (class 1259 OID 19503346)
-- Name: skill; Type: TABLE; Schema: skillmatch; Owner: postgres
--

CREATE TABLE skill (
    id integer NOT NULL,
    skill_desc integer NOT NULL,
    skill_type integer,
    date_added date,
    status_id integer
);


ALTER TABLE skill OWNER TO postgres;

--
-- TOC entry 190 (class 1259 OID 19503344)
-- Name: skill_id_seq; Type: SEQUENCE; Schema: skillmatch; Owner: postgres
--

CREATE SEQUENCE skill_id_seq
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;


ALTER TABLE skill_id_seq OWNER TO postgres;

--
-- TOC entry 2459 (class 0 OID 0)
-- Dependencies: 190
-- Name: skill_id_seq; Type: SEQUENCE OWNED BY; Schema: skillmatch; Owner: postgres
--

ALTER SEQUENCE skill_id_seq OWNED BY skill.id;


--
-- TOC entry 193 (class 1259 OID 19503354)
-- Name: skill_level; Type: TABLE; Schema: skillmatch; Owner: postgres
--

CREATE TABLE skill_level (
    id integer NOT NULL,
    skill_id integer NOT NULL,
    level_id integer NOT NULL
);


ALTER TABLE skill_level OWNER TO postgres;

--
-- TOC entry 192 (class 1259 OID 19503352)
-- Name: skill_level_id_seq; Type: SEQUENCE; Schema: skillmatch; Owner: postgres
--

CREATE SEQUENCE skill_level_id_seq
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;


ALTER TABLE skill_level_id_seq OWNER TO postgres;

--
-- TOC entry 2460 (class 0 OID 0)
-- Dependencies: 192
-- Name: skill_level_id_seq; Type: SEQUENCE OWNED BY; Schema: skillmatch; Owner: postgres
--

ALTER SEQUENCE skill_level_id_seq OWNED BY skill_level.id;


--
-- TOC entry 183 (class 1259 OID 15397570)
-- Name: user; Type: TABLE; Schema: skillmatch; Owner: postgres
--

CREATE TABLE "user" (
    id integer NOT NULL,
    name character varying NOT NULL,
    last_name character varying,
    address_id integer NOT NULL,
    image_id integer
);


ALTER TABLE "user" OWNER TO postgres;

--
-- TOC entry 182 (class 1259 OID 15397568)
-- Name: user_id_seq; Type: SEQUENCE; Schema: skillmatch; Owner: postgres
--

CREATE SEQUENCE user_id_seq
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;


ALTER TABLE user_id_seq OWNER TO postgres;

--
-- TOC entry 2461 (class 0 OID 0)
-- Dependencies: 182
-- Name: user_id_seq; Type: SEQUENCE OWNED BY; Schema: skillmatch; Owner: postgres
--

ALTER SEQUENCE user_id_seq OWNED BY "user".id;


--
-- TOC entry 195 (class 1259 OID 19503363)
-- Name: user_skill; Type: TABLE; Schema: skillmatch; Owner: postgres
--

CREATE TABLE user_skill (
    id integer NOT NULL,
    user_id integer NOT NULL,
    skill_level_id integer NOT NULL,
    date_added date,
    status_id integer
);


ALTER TABLE user_skill OWNER TO postgres;

--
-- TOC entry 194 (class 1259 OID 19503361)
-- Name: user_skill_id_seq; Type: SEQUENCE; Schema: skillmatch; Owner: postgres
--

CREATE SEQUENCE user_skill_id_seq
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;


ALTER TABLE user_skill_id_seq OWNER TO postgres;

--
-- TOC entry 2462 (class 0 OID 0)
-- Dependencies: 194
-- Name: user_skill_id_seq; Type: SEQUENCE OWNED BY; Schema: skillmatch; Owner: postgres
--

ALTER SEQUENCE user_skill_id_seq OWNED BY user_skill.id;


--
-- TOC entry 2290 (class 2604 OID 15397595)
-- Name: id; Type: DEFAULT; Schema: skillmatch; Owner: postgres
--

ALTER TABLE ONLY address ALTER COLUMN id SET DEFAULT nextval('address_id_seq'::regclass);


--
-- TOC entry 2291 (class 2604 OID 15397607)
-- Name: id; Type: DEFAULT; Schema: skillmatch; Owner: postgres
--

ALTER TABLE ONLY catalog ALTER COLUMN id SET DEFAULT nextval('catalog_id_seq'::regclass);


--
-- TOC entry 2289 (class 2604 OID 15397584)
-- Name: id; Type: DEFAULT; Schema: skillmatch; Owner: postgres
--

ALTER TABLE ONLY contact ALTER COLUMN id SET DEFAULT nextval('contact_id_seq'::regclass);


--
-- TOC entry 2292 (class 2604 OID 19503349)
-- Name: id; Type: DEFAULT; Schema: skillmatch; Owner: postgres
--

ALTER TABLE ONLY skill ALTER COLUMN id SET DEFAULT nextval('skill_id_seq'::regclass);


--
-- TOC entry 2293 (class 2604 OID 19503357)
-- Name: id; Type: DEFAULT; Schema: skillmatch; Owner: postgres
--

ALTER TABLE ONLY skill_level ALTER COLUMN id SET DEFAULT nextval('skill_level_id_seq'::regclass);


--
-- TOC entry 2288 (class 2604 OID 15397573)
-- Name: id; Type: DEFAULT; Schema: skillmatch; Owner: postgres
--

ALTER TABLE ONLY "user" ALTER COLUMN id SET DEFAULT nextval('user_id_seq'::regclass);


--
-- TOC entry 2294 (class 2604 OID 19503366)
-- Name: id; Type: DEFAULT; Schema: skillmatch; Owner: postgres
--

ALTER TABLE ONLY user_skill ALTER COLUMN id SET DEFAULT nextval('user_skill_id_seq'::regclass);


--
-- TOC entry 2443 (class 0 OID 15397592)
-- Dependencies: 187
-- Data for Name: address; Type: TABLE DATA; Schema: skillmatch; Owner: postgres
--

INSERT INTO address (id, street, number, po_box, line_extra) VALUES (45, '3420 Finnian Way', NULL, '94568', 'Apartment 408');


--
-- TOC entry 2463 (class 0 OID 0)
-- Dependencies: 186
-- Name: address_id_seq; Type: SEQUENCE SET; Schema: skillmatch; Owner: postgres
--

SELECT pg_catalog.setval('address_id_seq', 45, true);


--
-- TOC entry 2445 (class 0 OID 15397604)
-- Dependencies: 189
-- Data for Name: catalog; Type: TABLE DATA; Schema: skillmatch; Owner: postgres
--

INSERT INTO catalog (id, text, parent_id) VALUES (2406, 'status', NULL);
INSERT INTO catalog (id, text, parent_id) VALUES (2407, 'live', 2406);
INSERT INTO catalog (id, text, parent_id) VALUES (2408, 'created', 2406);
INSERT INTO catalog (id, text, parent_id) VALUES (2409, 'deleted', 2406);
INSERT INTO catalog (id, text, parent_id) VALUES (2410, 'skills', NULL);
INSERT INTO catalog (id, text, parent_id) VALUES (2411, 'java', 2410);
INSERT INTO catalog (id, text, parent_id) VALUES (2412, 'skillType', NULL);
INSERT INTO catalog (id, text, parent_id) VALUES (2413, 'programming', 2411);
INSERT INTO catalog (id, text, parent_id) VALUES (2414, 'level', NULL);
INSERT INTO catalog (id, text, parent_id) VALUES (2415, 'beginner', 2414);
INSERT INTO catalog (id, text, parent_id) VALUES (2416, 'intermediate', 2414);
INSERT INTO catalog (id, text, parent_id) VALUES (2417, 'advanced', 2414);
INSERT INTO catalog (id, text, parent_id) VALUES (2418, 'master', 2414);


--
-- TOC entry 2464 (class 0 OID 0)
-- Dependencies: 188
-- Name: catalog_id_seq; Type: SEQUENCE SET; Schema: skillmatch; Owner: postgres
--

SELECT pg_catalog.setval('catalog_id_seq', 48, true);


--
-- TOC entry 2441 (class 0 OID 15397581)
-- Dependencies: 185
-- Data for Name: contact; Type: TABLE DATA; Schema: skillmatch; Owner: postgres
--



--
-- TOC entry 2465 (class 0 OID 0)
-- Dependencies: 184
-- Name: contact_id_seq; Type: SEQUENCE SET; Schema: skillmatch; Owner: postgres
--

SELECT pg_catalog.setval('contact_id_seq', 1, false);


--
-- TOC entry 2447 (class 0 OID 19503346)
-- Dependencies: 191
-- Data for Name: skill; Type: TABLE DATA; Schema: skillmatch; Owner: postgres
--

INSERT INTO skill (id, skill_desc, skill_type, date_added, status_id) VALUES (600, 2411, 2413, '2016-07-16', 2407);


--
-- TOC entry 2466 (class 0 OID 0)
-- Dependencies: 190
-- Name: skill_id_seq; Type: SEQUENCE SET; Schema: skillmatch; Owner: postgres
--

SELECT pg_catalog.setval('skill_id_seq', 12, true);


--
-- TOC entry 2449 (class 0 OID 19503354)
-- Dependencies: 193
-- Data for Name: skill_level; Type: TABLE DATA; Schema: skillmatch; Owner: postgres
--

INSERT INTO skill_level (id, skill_id, level_id) VALUES (500, 600, 2417);


--
-- TOC entry 2467 (class 0 OID 0)
-- Dependencies: 192
-- Name: skill_level_id_seq; Type: SEQUENCE SET; Schema: skillmatch; Owner: postgres
--

SELECT pg_catalog.setval('skill_level_id_seq', 10, true);


--
-- TOC entry 2439 (class 0 OID 15397570)
-- Dependencies: 183
-- Data for Name: user; Type: TABLE DATA; Schema: skillmatch; Owner: postgres
--

INSERT INTO "user" (id, name, last_name, address_id, image_id) VALUES (700, 'Alejandro', 'Geremnos', 45, NULL);


--
-- TOC entry 2468 (class 0 OID 0)
-- Dependencies: 182
-- Name: user_id_seq; Type: SEQUENCE SET; Schema: skillmatch; Owner: postgres
--

SELECT pg_catalog.setval('user_id_seq', 14, true);


--
-- TOC entry 2451 (class 0 OID 19503363)
-- Dependencies: 195
-- Data for Name: user_skill; Type: TABLE DATA; Schema: skillmatch; Owner: postgres
--

INSERT INTO user_skill (id, user_id, skill_level_id, date_added, status_id) VALUES (450, 700, 500, '2016-07-16', 2407);


--
-- TOC entry 2469 (class 0 OID 0)
-- Dependencies: 194
-- Name: user_skill_id_seq; Type: SEQUENCE SET; Schema: skillmatch; Owner: postgres
--

SELECT pg_catalog.setval('user_skill_id_seq', 9, true);


--
-- TOC entry 2301 (class 2606 OID 15397600)
-- Name: address_pkey; Type: CONSTRAINT; Schema: skillmatch; Owner: postgres
--

ALTER TABLE ONLY address
    ADD CONSTRAINT address_pkey PRIMARY KEY (id);


--
-- TOC entry 2304 (class 2606 OID 15397612)
-- Name: catalog_pkey; Type: CONSTRAINT; Schema: skillmatch; Owner: postgres
--

ALTER TABLE ONLY catalog
    ADD CONSTRAINT catalog_pkey PRIMARY KEY (id);


--
-- TOC entry 2298 (class 2606 OID 15397589)
-- Name: contact_pkey; Type: CONSTRAINT; Schema: skillmatch; Owner: postgres
--

ALTER TABLE ONLY contact
    ADD CONSTRAINT contact_pkey PRIMARY KEY (id);


--
-- TOC entry 2309 (class 2606 OID 19503359)
-- Name: skill_level_pkey; Type: CONSTRAINT; Schema: skillmatch; Owner: postgres
--

ALTER TABLE ONLY skill_level
    ADD CONSTRAINT skill_level_pkey PRIMARY KEY (id);


--
-- TOC entry 2306 (class 2606 OID 19503351)
-- Name: skill_pkey; Type: CONSTRAINT; Schema: skillmatch; Owner: postgres
--

ALTER TABLE ONLY skill
    ADD CONSTRAINT skill_pkey PRIMARY KEY (id);


--
-- TOC entry 2296 (class 2606 OID 15397578)
-- Name: user_pkey; Type: CONSTRAINT; Schema: skillmatch; Owner: postgres
--

ALTER TABLE ONLY "user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);


--
-- TOC entry 2312 (class 2606 OID 19503368)
-- Name: user_skill_pkey; Type: CONSTRAINT; Schema: skillmatch; Owner: postgres
--

ALTER TABLE ONLY user_skill
    ADD CONSTRAINT user_skill_pkey PRIMARY KEY (id);


--
-- TOC entry 2299 (class 1259 OID 15397601)
-- Name: address_id_uindex; Type: INDEX; Schema: skillmatch; Owner: postgres
--

CREATE UNIQUE INDEX address_id_uindex ON address USING btree (id);


--
-- TOC entry 2302 (class 1259 OID 15397613)
-- Name: catalog_id_uindex; Type: INDEX; Schema: skillmatch; Owner: postgres
--

CREATE UNIQUE INDEX catalog_id_uindex ON catalog USING btree (id);


--
-- TOC entry 2307 (class 1259 OID 19503360)
-- Name: skill_level_id_uindex; Type: INDEX; Schema: skillmatch; Owner: postgres
--

CREATE UNIQUE INDEX skill_level_id_uindex ON skill_level USING btree (id);


--
-- TOC entry 2310 (class 1259 OID 19503369)
-- Name: user_skill_id_uindex; Type: INDEX; Schema: skillmatch; Owner: postgres
--

CREATE UNIQUE INDEX user_skill_id_uindex ON user_skill USING btree (id);


--
-- TOC entry 2314 (class 2606 OID 23647173)
-- Name: contact_contact_type_id_fkey; Type: FK CONSTRAINT; Schema: skillmatch; Owner: postgres
--

ALTER TABLE ONLY contact
    ADD CONSTRAINT contact_contact_type_id_fkey FOREIGN KEY (contact_type_id) REFERENCES catalog(id);


--
-- TOC entry 2315 (class 2606 OID 23647178)
-- Name: contact_user_id_fkey; Type: FK CONSTRAINT; Schema: skillmatch; Owner: postgres
--

ALTER TABLE ONLY contact
    ADD CONSTRAINT contact_user_id_fkey FOREIGN KEY (user_id) REFERENCES "user"(id);


--
-- TOC entry 2320 (class 2606 OID 23647148)
-- Name: skill_level_level_id_fkey; Type: FK CONSTRAINT; Schema: skillmatch; Owner: postgres
--

ALTER TABLE ONLY skill_level
    ADD CONSTRAINT skill_level_level_id_fkey FOREIGN KEY (level_id) REFERENCES catalog(id);


--
-- TOC entry 2319 (class 2606 OID 23647143)
-- Name: skill_level_skill_id_fkey; Type: FK CONSTRAINT; Schema: skillmatch; Owner: postgres
--

ALTER TABLE ONLY skill_level
    ADD CONSTRAINT skill_level_skill_id_fkey FOREIGN KEY (skill_id) REFERENCES skill(id);


--
-- TOC entry 2316 (class 2606 OID 23647128)
-- Name: skill_skill_desc_fkey; Type: FK CONSTRAINT; Schema: skillmatch; Owner: postgres
--

ALTER TABLE ONLY skill
    ADD CONSTRAINT skill_skill_desc_fkey FOREIGN KEY (skill_desc) REFERENCES catalog(id);


--
-- TOC entry 2317 (class 2606 OID 23647133)
-- Name: skill_skill_type_fkey; Type: FK CONSTRAINT; Schema: skillmatch; Owner: postgres
--

ALTER TABLE ONLY skill
    ADD CONSTRAINT skill_skill_type_fkey FOREIGN KEY (skill_type) REFERENCES catalog(id);


--
-- TOC entry 2318 (class 2606 OID 23647138)
-- Name: skill_status_id_fkey; Type: FK CONSTRAINT; Schema: skillmatch; Owner: postgres
--

ALTER TABLE ONLY skill
    ADD CONSTRAINT skill_status_id_fkey FOREIGN KEY (status_id) REFERENCES catalog(id);


--
-- TOC entry 2313 (class 2606 OID 23647123)
-- Name: user_address_id_fkey; Type: FK CONSTRAINT; Schema: skillmatch; Owner: postgres
--

ALTER TABLE ONLY "user"
    ADD CONSTRAINT user_address_id_fkey FOREIGN KEY (address_id) REFERENCES address(id);


--
-- TOC entry 2322 (class 2606 OID 23647158)
-- Name: user_skill_skill_level_id_fkey; Type: FK CONSTRAINT; Schema: skillmatch; Owner: postgres
--

ALTER TABLE ONLY user_skill
    ADD CONSTRAINT user_skill_skill_level_id_fkey FOREIGN KEY (skill_level_id) REFERENCES skill_level(id);


--
-- TOC entry 2323 (class 2606 OID 23647163)
-- Name: user_skill_status_id_fkey; Type: FK CONSTRAINT; Schema: skillmatch; Owner: postgres
--

ALTER TABLE ONLY user_skill
    ADD CONSTRAINT user_skill_status_id_fkey FOREIGN KEY (status_id) REFERENCES catalog(id);


--
-- TOC entry 2321 (class 2606 OID 23647153)
-- Name: user_skill_user_id_fkey; Type: FK CONSTRAINT; Schema: skillmatch; Owner: postgres
--

ALTER TABLE ONLY user_skill
    ADD CONSTRAINT user_skill_user_id_fkey FOREIGN KEY (user_id) REFERENCES "user"(id);


-- Completed on 2016-07-16 17:45:10 PDT

--
-- PostgreSQL database dump complete
--

