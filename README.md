
# Generative AI Project

The generative AI project is an experimental project that proves we don't need artificial intelligence to implement various solutions. This application allows you to easily retreive the list of all countries, moreover you're able to apply filters and sorting features. If you need more information about the country's fields, [click here](https://gitlab.com/restcountries/restcountries/-/blob/master/FIELDS.md).
## Run Locally

Clone the project

```bash
  git clone https://github.com/antoshaSid/generative-AI-experiment.git
```

Go to the project directory

```bash
  cd generative-AI-experiment
```

Start the server

```bash
  ./mvnw spring-boot:run
```

Run unit tests

```bash
  ./mvnw test
```


## Examples

### Retrieve all countries

```http
http://localhost:8080/country/all
```

Resulted list

```json
[
  {
    "name": {
      "common": "South Africa",
      ...
    }
    "population": 59308690,
    ...
  },
  ...
]
```

### Retrieve all countries filtered by names

```http
http://localhost:8080/country/all?name=COUNTRY_NAME
```

Let's filter the list by `ukr`

```http
http://localhost:8080/country/all?name=ukr
```

Resulted list

```json
[
  {
    "name": {
      "common": "Ukraine",
      "official": "Ukraine",
      "nativeName": {
        "ukr": {
          "official": "Україна",
          "common": "Україна"
        }
      }
    },
    ...
  }
]
```

### Retrieve all countries filtered by less than population

```http
http://localhost:8080/country/all?population=POPULATION_NUMBER
```

`POPULATION_NUMBER` - the population number in the millions of people

For instance, let's get the countries where the population is less than 1 million

```http
http://localhost:8080/country/all?population=1
```

Resulted list

```json
[
  {
    "name": {
      "common": "Svalbard and Jan Mayen",
      "official": "Svalbard og Jan Mayen",
      "nativeName": {
        "nor": {
          "official": "Svalbard og Jan Mayen",
          "common": "Svalbard og Jan Mayen"
        }
      }
    },
    "population": 2562,
    ...
  },
  ...
]
```

### Retrieve all countries sorted by name

```http
http://localhost:8080/country/all?sort=SORT_DIRECTION
```

`SORT_DIRECTION` - ascend or descend

Let's sort ascend

```http
http://localhost:8080/country/all?sort=ascend
```

Resulted list

```json
[
  {
    "name": {
      "common": "Afghanistan",
      "official": "Islamic Republic of Afghanistan",
      "nativeName": {
        "prs": {
          "official": "جمهوری اسلامی افغانستان",
          "common": "افغانستان"
        },
        "pus": {
          "official": "د افغانستان اسلامي جمهوریت",
          "common": "افغانستان"
        },
        "tuk": {
          "official": "Owganystan Yslam Respublikasy",
          "common": "Owganystan"
        }
      }
    }
  },
  ...
]
```

Let's sort descend

```http
http://localhost:8080/country/all?sort=descend
```

Resulted list

```json
[
  {
    "name": {
      "common": "Åland Islands",
      "official": "Åland Islands",
      "nativeName": {
        "swe": {
          "official": "Landskapet Åland",
          "common": "Åland"
        }
      }
    }
  },
  ...
]
```

### Retrieve all countries with pagination

```http
http://localhost:8080/country/all?limit=LIMIT_NUMBER
```

`LIMIT_NUMBER` - the limit number of retrieved countries

For instance, let's get 6 countries

```http
http://localhost:8080/country/all?limit=6
```

Resulted list

```json
[
  {
    "name": {
      "common": "South Africa",
      ...
    }
    "population": 59308690,
    ...
  },
  ... and 5 more
]
```

### Retrieve all countries with filter and sort

In the following example, we're going to retrieve 5 sorted countries that are filtered by name and population

```http
http://localhost:8080/country/all?name=land&population=10&sort=ascend&limit=5
```

Resulted list

```json
[
  {
    "name": {
      "common": "Bouvet Island",
      "official": "Bouvet Island",
      "nativeName": {
        "nor": {
          "official": "Bouvetøya",
          "common": "Bouvetøya"
        }
      }
    },
    "tld": [
      ".bv"
    ],
    "cca2": "BV",
    "ccn3": "074",
    "cca3": "BVT",
    "independent": false,
    "status": "officially-assigned",
    "unMember": false,
    "idd": {
      "root": "+4",
      "suffixes": [
        "7"
      ]
    },
    "altSpellings": [
      "BV",
      "Bouvetøya",
      "Bouvet-øya"
    ],
    "region": "Antarctic",
    "languages": {
      "nor": "Norwegian"
    },
    "translations": {
      "ara": {
        "official": "جزر بوفيه",
        "common": "جزر بوفيه"
      },
      "bre": {
        "official": "Enez Bouvet",
        "common": "Enez Bouvet"
      },
      "ces": {
        "official": "Bouvetův ostrov",
        "common": "Bouvetův ostrov"
      },
      "cym": {
        "official": "Bouvet Island",
        "common": "Bouvet Island"
      },
      "deu": {
        "official": "Bouvetinsel",
        "common": "Bouvetinsel"
      },
      "est": {
        "official": "Bouvet’ saar",
        "common": "Bouvet’ saar"
      },
      "fin": {
        "official": "Bouvet'nsaari",
        "common": "Bouvet'nsaari"
      },
      "fra": {
        "official": "Île Bouvet",
        "common": "Île Bouvet"
      },
      "hrv": {
        "official": "Bouvet Island",
        "common": "Otok Bouvet"
      },
      "hun": {
        "official": "Bouvet-sziget",
        "common": "Bouvet-sziget"
      },
      "ita": {
        "official": "Isola Bouvet",
        "common": "Isola Bouvet"
      },
      "jpn": {
        "official": "ブーヴェ島",
        "common": "ブーベ島"
      },
      "kor": {
        "official": "부베 섬",
        "common": "부베 섬"
      },
      "nld": {
        "official": "Bouvet Island",
        "common": "Bouveteiland"
      },
      "per": {
        "official": "جزیرهٔ بووه",
        "common": "جزیرهٔ بووه"
      },
      "pol": {
        "official": "Wyspa Bouveta",
        "common": "Wyspa Bouveta"
      },
      "por": {
        "official": "Ilha Bouvet",
        "common": "Ilha Bouvet"
      },
      "rus": {
        "official": "Остров Буве",
        "common": "Остров Буве"
      },
      "slk": {
        "official": "Bouvetov ostrov",
        "common": "Bouvetov ostrov"
      },
      "spa": {
        "official": "Isla Bouvet",
        "common": "Isla Bouvet"
      },
      "srp": {
        "official": "Буве",
        "common": "Буве"
      },
      "swe": {
        "official": "Bouvetön",
        "common": "Bouvetön"
      },
      "tur": {
        "official": "Bouvet Adası",
        "common": "Bouvet Adası"
      },
      "urd": {
        "official": "جزیرہ بووہ",
        "common": "جزیرہ بووہ"
      },
      "zho": {
        "official": "布维岛",
        "common": "布维岛"
      }
    },
    "latlng": [
      54.4208,
      3.3464
    ],
    "landlocked": false,
    "area": 49,
    "flag": "🇧🇻",
    "maps": {
      "googleMaps": "https://goo.gl/maps/7WRQAEKZb4uK36yi9",
      "openStreetMaps": "https://www.openstreetmap.org/way/174996681"
    },
    "population": 0,
    "car": {
      "signs": [
        ""
      ],
      "side": "right"
    },
    "timezones": [
      "UTC+01:00"
    ],
    "continents": [
      "Antarctica"
    ],
    "flags": {
      "png": "https://flagcdn.com/w320/bv.png",
      "svg": "https://flagcdn.com/bv.svg"
    },
    "coatOfArms": {},
    "startOfWeek": "monday",
    "capitalInfo": {}
  },
  {
    "name": {
      "common": "British Virgin Islands",
      "official": "Virgin Islands",
      "nativeName": {
        "eng": {
          "official": "Virgin Islands",
          "common": "British Virgin Islands"
        }
      }
    },
    "tld": [
      ".vg"
    ],
    "cca2": "VG",
    "ccn3": "092",
    "cca3": "VGB",
    "cioc": "IVB",
    "independent": false,
    "status": "officially-assigned",
    "unMember": false,
    "currencies": {
      "USD": {
        "name": "United States dollar",
        "symbol": "$"
      }
    },
    "idd": {
      "root": "+1",
      "suffixes": [
        "284"
      ]
    },
    "capital": [
      "Road Town"
    ],
    "altSpellings": [
      "VG",
      "Virgin Islands, British"
    ],
    "region": "Americas",
    "subregion": "Caribbean",
    "languages": {
      "eng": "English"
    },
    "translations": {
      "ara": {
        "official": "جزر العذراء البريطانية",
        "common": "جزر العذراء"
      },
      "bre": {
        "official": "Inizi Gwerc'h Breizhveurat",
        "common": "Inizi Gwerc'h Breizhveurat"
      },
      "ces": {
        "official": "Britské Panenské ostrovy",
        "common": "Britské Panenské ostrovy"
      },
      "cym": {
        "official": "Virgin Islands",
        "common": "British Virgin Islands"
      },
      "deu": {
        "official": "Jungferninseln",
        "common": "Britische Jungferninseln"
      },
      "est": {
        "official": "Neitsisaared",
        "common": "Briti Neitsisaared"
      },
      "fin": {
        "official": "Brittiläiset Neitsytsaaret",
        "common": "Neitsytsaaret"
      },
      "fra": {
        "official": "îles Vierges",
        "common": "Îles Vierges britanniques"
      },
      "hrv": {
        "official": "Djevičanski Otoci",
        "common": "Britanski Djevičanski Otoci"
      },
      "hun": {
        "official": "Brit Virgin-szigetek",
        "common": "Brit Virgin-szigetek"
      },
      "ita": {
        "official": "Isole Vergini",
        "common": "Isole Vergini Britanniche"
      },
      "jpn": {
        "official": "バージン諸島",
        "common": "イギリス領ヴァージン諸島"
      },
      "kor": {
        "official": "영국령 버진아일랜드",
        "common": "영국령 버진아일랜드"
      },
      "nld": {
        "official": "Maagdeneilanden",
        "common": "Britse Maagdeneilanden"
      },
      "per": {
        "official": "جزایر ویرجین بریتانیا",
        "common": "جزایر ویرجین بریتانیا"
      },
      "pol": {
        "official": "Brytyjskie Wyspy Dziewicze",
        "common": "Brytyjskie Wyspy Dziewicze"
      },
      "por": {
        "official": "Ilhas Virgens",
        "common": "Ilhas Virgens"
      },
      "rus": {
        "official": "Виргинские острова",
        "common": "Британские Виргинские острова"
      },
      "slk": {
        "official": "Panenské ostrovy",
        "common": "Panenské ostrovy"
      },
      "spa": {
        "official": "Islas Vírgenes",
        "common": "Islas Vírgenes del Reino Unido"
      },
      "srp": {
        "official": "Британска Девичанска Острва",
        "common": "Британска Девичанска Острва"
      },
      "swe": {
        "official": "Brittiska Jungfruöarna",
        "common": "Brittiska Jungfruöarna"
      },
      "tur": {
        "official": "Virjin Adaları",
        "common": "Virjin Adaları"
      },
      "urd": {
        "official": "برطانوی جزائر ورجن",
        "common": "برطانوی جزائر ورجن"
      },
      "zho": {
        "official": "英属维尔京群岛",
        "common": "英属维尔京群岛"
      }
    },
    "latlng": [
      18.431383,
      -64.62305
    ],
    "landlocked": false,
    "area": 151,
    "demonyms": {
      "eng": {
        "f": "Virgin Islander",
        "m": "Virgin Islander"
      }
    },
    "flag": "🇻🇬",
    "maps": {
      "googleMaps": "https://goo.gl/maps/49C9cSesNVAR9DQk8",
      "openStreetMaps": "https://www.openstreetmap.org/relation/285454"
    },
    "population": 30237,
    "fifa": "VGB",
    "car": {
      "signs": [
        "BVI"
      ],
      "side": "left"
    },
    "timezones": [
      "UTC-04:00"
    ],
    "continents": [
      "North America"
    ],
    "flags": {
      "png": "https://flagcdn.com/w320/vg.png",
      "svg": "https://flagcdn.com/vg.svg"
    },
    "coatOfArms": {
      "png": "https://mainfacts.com/media/images/coats_of_arms/vg.png",
      "svg": "https://mainfacts.com/media/images/coats_of_arms/vg.svg"
    },
    "startOfWeek": "monday",
    "capitalInfo": {
      "latlng": [
        18.42,
        -64.62
      ]
    }
  },
  {
    "name": {
      "common": "Caribbean Netherlands",
      "official": "Bonaire, Sint Eustatius and Saba",
      "nativeName": {
        "nld": {
          "official": "Bonaire, Sint Eustatius en Saba",
          "common": "Caribisch Nederland"
        },
        "pap": {
          "official": "Boneiru, Sint Eustatius y Saba",
          "common": "Boneiru, Sint Eustatius y Saba"
        }
      }
    },
    "tld": [
      ".bq",
      ".nl"
    ],
    "cca2": "BQ",
    "ccn3": "535",
    "cca3": "BES",
    "independent": false,
    "status": "officially-assigned",
    "unMember": false,
    "currencies": {
      "USD": {
        "name": "United States dollar",
        "symbol": "$"
      }
    },
    "idd": {
      "root": "+5",
      "suffixes": [
        "99"
      ]
    },
    "capital": [
      "Kralendijk"
    ],
    "altSpellings": [
      "BES islands"
    ],
    "region": "Americas",
    "subregion": "Caribbean",
    "languages": {
      "eng": "English",
      "nld": "Dutch",
      "pap": "Papiamento"
    },
    "translations": {
      "ara": {
        "official": "بونير وسينت أوستاتيوس وسابا",
        "common": "الجزر الكاريبية الهولندية"
      },
      "bre": {
        "official": "Bonaire, Sint Eustatius ha Saba",
        "common": "Bonaire, Sint Eustatius ha Saba"
      },
      "ces": {
        "official": "Karibské Nizozemsko",
        "common": "Karibské Nizozemsko"
      },
      "cym": {
        "official": "Bonaire, Sint Eustatius and Saba",
        "common": "Caribbean Netherlands"
      },
      "deu": {
        "official": "Bonaire, Sint Eustatius und Saba",
        "common": "Karibische Niederlande"
      },
      "est": {
        "official": "Bonaire, Sint Eustatius ja Saba",
        "common": "Bonaire, Sint Eustatius ja Saba"
      },
      "fin": {
        "official": "Bonaire, Sint Eustatius ja Saba",
        "common": "Bonaire, Sint Eustatius ja Saba"
      },
      "fra": {
        "official": "Bonaire, Saint-Eustache et Saba",
        "common": "Pays-Bas caribéens"
      },
      "hrv": {
        "official": "Bonaire, Sint Eustatius i Saba",
        "common": "Bonaire, Sint Eustatius i Saba"
      },
      "hun": {
        "official": "Bonaire",
        "common": "Bonaire"
      },
      "ita": {
        "official": "Bonaire, Sint Eustatius e Saba",
        "common": "Paesi Bassi caraibici"
      },
      "jpn": {
        "official": "ボネール、シント・ユースタティウスおよびサバ",
        "common": "ボネール、シント・ユースタティウスおよびサバ"
      },
      "kor": {
        "official": "보네르, 신트외스타티위스, 사바",
        "common": "카리브 네덜란드"
      },
      "nld": {
        "official": "Bonaire, Sint Eustatius en Saba",
        "common": "Caribisch Nederland"
      },
      "per": {
        "official": "جزایر کارائیب هلند",
        "common": "جزایر کارائیب هلند"
      },
      "pol": {
        "official": "Bonaire, Sint Eustatius i Saba",
        "common": "Antyle Holenderskie"
      },
      "por": {
        "official": "Bonaire, Saba e Santo Eustáquio",
        "common": "Países Baixos Caribenhos"
      },
      "rus": {
        "official": "Бонэйр, Синт-Эстатиус и Саба",
        "common": "Карибские Нидерланды"
      },
      "slk": {
        "official": "Bonaire, Sint Eustatius a Saba",
        "common": "Bonaire, Sint Eustatius a Saba"
      },
      "spa": {
        "official": "Bonaire, San Eustaquio y Saba",
        "common": "Caribe Neerlandés"
      },
      "srp": {
        "official": "Бонер, Свети Еустахије и Саба",
        "common": "Карипска Холандија"
      },
      "swe": {
        "official": "Bonaire, Sint Eustatius and Saba",
        "common": "Karibiska Nederländerna"
      },
      "tur": {
        "official": "Karayip Hollandası",
        "common": "Karayip Hollandası"
      },
      "urd": {
        "official": "بونایر، سینٹ ایوسٹائیس اور سابا",
        "common": "کیریبین نیدرلینڈز"
      },
      "zho": {
        "official": "荷蘭加勒比區",
        "common": "荷蘭加勒比區"
      }
    },
    "latlng": [
      12.18,
      -68.25
    ],
    "landlocked": false,
    "area": 328,
    "demonyms": {
      "eng": {
        "f": "Dutch",
        "m": "Dutch"
      },
      "fra": {
        "f": "Néerlandaise",
        "m": "Néerlandais"
      }
    },
    "flag": "🇧🇶",
    "maps": {
      "googleMaps": "https://goo.gl/maps/4XVes1P6uEDTz77WA",
      "openStreetMaps": "https://www.openstreetmap.org/relation/1216720"
    },
    "population": 25987,
    "car": {
      "signs": [
        ""
      ],
      "side": "right"
    },
    "timezones": [
      "UTC-04:00"
    ],
    "continents": [
      "North America"
    ],
    "flags": {
      "png": "https://flagcdn.com/w320/bq.png",
      "svg": "https://flagcdn.com/bq.svg"
    },
    "coatOfArms": {
      "png": "https://mainfacts.com/media/images/coats_of_arms/bq.png",
      "svg": "https://mainfacts.com/media/images/coats_of_arms/bq.svg"
    },
    "startOfWeek": "monday",
    "capitalInfo": {
      "latlng": [
        12.14,
        -68.27
      ]
    }
  },
  {
    "name": {
      "common": "Cayman Islands",
      "official": "Cayman Islands",
      "nativeName": {
        "eng": {
          "official": "Cayman Islands",
          "common": "Cayman Islands"
        }
      }
    },
    "tld": [
      ".ky"
    ],
    "cca2": "KY",
    "ccn3": "136",
    "cca3": "CYM",
    "cioc": "CAY",
    "independent": false,
    "status": "officially-assigned",
    "unMember": false,
    "currencies": {
      "KYD": {
        "name": "Cayman Islands dollar",
        "symbol": "$"
      }
    },
    "idd": {
      "root": "+1",
      "suffixes": [
        "345"
      ]
    },
    "capital": [
      "George Town"
    ],
    "altSpellings": [
      "KY"
    ],
    "region": "Americas",
    "subregion": "Caribbean",
    "languages": {
      "eng": "English"
    },
    "translations": {
      "ara": {
        "official": "جزر كايمان",
        "common": "جزر كايمان"
      },
      "bre": {
        "official": "Inizi Cayman",
        "common": "Inizi Cayman"
      },
      "ces": {
        "official": "Kajmanské ostrovy",
        "common": "Kajmanské ostrovy"
      },
      "cym": {
        "official": "Ynysoedd Cayman",
        "common": "Ynysoedd Cayman"
      },
      "deu": {
        "official": "Cayman-Inseln",
        "common": "Kaimaninseln"
      },
      "est": {
        "official": "Kaimanisaared",
        "common": "Kaimanisaared"
      },
      "fin": {
        "official": "Caymansaaret",
        "common": "Caymansaaret"
      },
      "fra": {
        "official": "Îles Caïmans",
        "common": "Îles Caïmans"
      },
      "hrv": {
        "official": "Kajmanski otoci",
        "common": "Kajmanski otoci"
      },
      "hun": {
        "official": "Kajmán-szigetek",
        "common": "Kajmán-szigetek"
      },
      "ita": {
        "official": "Isole Cayman",
        "common": "Isole Cayman"
      },
      "jpn": {
        "official": "ケイマン諸島",
        "common": "ケイマン諸島"
      },
      "kor": {
        "official": "케이맨 제도",
        "common": "케이맨 제도"
      },
      "nld": {
        "official": "Caymaneilanden",
        "common": "Caymaneilanden"
      },
      "per": {
        "official": "جزایر کیمن",
        "common": "جزایر کیمن"
      },
      "pol": {
        "official": "Kajmany",
        "common": "Kajmany"
      },
      "por": {
        "official": "Ilhas Cayman",
        "common": "Ilhas Caimão"
      },
      "rus": {
        "official": "Каймановы острова",
        "common": "Каймановы острова"
      },
      "slk": {
        "official": "Kajmanie ostrovy",
        "common": "Kajmanie ostrovy"
      },
      "spa": {
        "official": "Islas Caimán",
        "common": "Islas Caimán"
      },
      "srp": {
        "official": "Кајманска Острва",
        "common": "Кајманска Острва"
      },
      "swe": {
        "official": "Caymanöarna",
        "common": "Caymanöarna"
      },
      "tur": {
        "official": "Cayman Adaları",
        "common": "Cayman Adaları"
      },
      "urd": {
        "official": "جزائر کیمین",
        "common": "جزائر کیمین"
      },
      "zho": {
        "official": "开曼群岛",
        "common": "开曼群岛"
      }
    },
    "latlng": [
      19.3133,
      -81.2546
    ],
    "landlocked": false,
    "area": 264,
    "demonyms": {
      "eng": {
        "f": "Caymanian",
        "m": "Caymanian"
      },
      "fra": {
        "f": "Caïmanienne",
        "m": "Caïmanien"
      }
    },
    "flag": "🇰🇾",
    "maps": {
      "googleMaps": "https://goo.gl/maps/P3ZVXX3LH63t91hL8",
      "openStreetMaps": "https://www.openstreetmap.org/relation/7269765"
    },
    "population": 65720,
    "fifa": "CAY",
    "car": {
      "signs": [
        "GB"
      ],
      "side": "left"
    },
    "timezones": [
      "UTC-05:00"
    ],
    "continents": [
      "North America"
    ],
    "flags": {
      "png": "https://flagcdn.com/w320/ky.png",
      "svg": "https://flagcdn.com/ky.svg"
    },
    "coatOfArms": {
      "png": "https://mainfacts.com/media/images/coats_of_arms/ky.png",
      "svg": "https://mainfacts.com/media/images/coats_of_arms/ky.svg"
    },
    "startOfWeek": "monday",
    "capitalInfo": {
      "latlng": [
        19.3,
        -81.38
      ]
    }
  },
  {
    "name": {
      "common": "Christmas Island",
      "official": "Territory of Christmas Island",
      "nativeName": {
        "eng": {
          "official": "Territory of Christmas Island",
          "common": "Christmas Island"
        }
      }
    },
    "tld": [
      ".cx"
    ],
    "cca2": "CX",
    "ccn3": "162",
    "cca3": "CXR",
    "independent": false,
    "status": "officially-assigned",
    "unMember": false,
    "currencies": {
      "AUD": {
        "name": "Australian dollar",
        "symbol": "$"
      }
    },
    "idd": {
      "root": "+6",
      "suffixes": [
        "1"
      ]
    },
    "capital": [
      "Flying Fish Cove"
    ],
    "altSpellings": [
      "CX",
      "Territory of Christmas Island"
    ],
    "region": "Oceania",
    "subregion": "Australia and New Zealand",
    "languages": {
      "eng": "English"
    },
    "translations": {
      "ara": {
        "official": "جزيرة كريسماس",
        "common": "جزيرة كريسماس"
      },
      "bre": {
        "official": "Tiriad Enez Christmas",
        "common": "Enez Christmas"
      },
      "ces": {
        "official": "Teritorium Vánočního ostrova",
        "common": "Vánoční ostrov"
      },
      "cym": {
        "official": "Tiriogaeth yr Ynys y Nadolig",
        "common": "Ynys y Nadolig"
      },
      "deu": {
        "official": "Gebiet der Weihnachtsinsel",
        "common": "Weihnachtsinsel"
      },
      "est": {
        "official": "Jõulusaare ala",
        "common": "Jõulusaar"
      },
      "fin": {
        "official": "Joulusaaren alue",
        "common": "Joulusaari"
      },
      "fra": {
        "official": "Territoire de l'île Christmas",
        "common": "Île Christmas"
      },
      "hrv": {
        "official": "Teritorij Božićni otok",
        "common": "Božićni otok"
      },
      "hun": {
        "official": "Karácsony-sziget",
        "common": "Karácsony-sziget"
      },
      "ita": {
        "official": "Territorio di Christmas Island",
        "common": "Isola di Natale"
      },
      "jpn": {
        "official": "クリスマス島の領土",
        "common": "クリスマス島"
      },
      "kor": {
        "official": "크리스마스 섬",
        "common": "크리스마스 섬"
      },
      "nld": {
        "official": "Grondgebied van Christmas Island",
        "common": "Christmaseiland"
      },
      "per": {
        "official": "جزیرهٔ کریسمس",
        "common": "جزیرهٔ کریسمس"
      },
      "pol": {
        "official": "Wyspa Bożego Narodzenia",
        "common": "Wyspa Bożego Narodzenia"
      },
      "por": {
        "official": "Território da Ilha Christmas",
        "common": "Ilha do Natal"
      },
      "rus": {
        "official": "Территория острова Рождества",
        "common": "Остров Рождества"
      },
      "slk": {
        "official": "Teritórium Vianočného ostrova",
        "common": "Vianočnú ostrov"
      },
      "spa": {
        "official": "Territorio de la Isla de Navidad",
        "common": "Isla de Navidad"
      },
      "srp": {
        "official": "Божићно Острво",
        "common": "Божићно Острво"
      },
      "swe": {
        "official": "Julön",
        "common": "Julön"
      },
      "tur": {
        "official": "Christmas Adası",
        "common": "Christmas Adası"
      },
      "urd": {
        "official": "ریاستِ جزیرہ کرسمس",
        "common": "جزیرہ کرسمس"
      },
      "zho": {
        "official": "圣诞岛",
        "common": "圣诞岛"
      }
    },
    "latlng": [
      -10.5,
      105.66666666
    ],
    "landlocked": false,
    "area": 135,
    "demonyms": {
      "eng": {
        "f": "Christmas Islander",
        "m": "Christmas Islander"
      }
    },
    "flag": "🇨🇽",
    "maps": {
      "googleMaps": "https://goo.gl/maps/ZC17hHsQZpShN5wk9",
      "openStreetMaps": "https://www.openstreetmap.org/relation/6365444"
    },
    "population": 2072,
    "car": {
      "signs": [
        "AUS"
      ],
      "side": "left"
    },
    "timezones": [
      "UTC+07:00"
    ],
    "continents": [
      "Asia"
    ],
    "flags": {
      "png": "https://flagcdn.com/w320/cx.png",
      "svg": "https://flagcdn.com/cx.svg"
    },
    "coatOfArms": {
      "png": "https://mainfacts.com/media/images/coats_of_arms/cx.png",
      "svg": "https://mainfacts.com/media/images/coats_of_arms/cx.svg"
    },
    "startOfWeek": "monday",
    "capitalInfo": {
      "latlng": [
        -10.42,
        105.68
      ]
    },
    "postalCode": {
      "format": "####",
      "regex": "^(\\d{4})$"
    }
  }
]
```