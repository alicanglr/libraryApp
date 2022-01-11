# libraryApp


Please create a library application.
This application should provide a REST API that satisfies the following requirements.


#
  a) returns all users who have actually borrowed at least one book
	
	
     request : http://localhost:1881/userWithAtLeastOneBorrow 
		 
		 
     [
    {
        "lastName": "Jumummaaq",
        "firstName": "James",
        "memberSince": "2004-04-30T21:00:00.000+00:00",
        "memberTill": "2008-08-05T21:00:00.000+00:00",
        "gender": "m"
    },
    {
        "lastName": "Odum",
        "firstName": "Oliver",
        "memberSince": "1999-05-07T21:00:00.000+00:00",
        "memberTill": "2020-12-31T21:00:00.000+00:00",
        "gender": "m"
    },
    {
        "lastName": "Augusta",
        "firstName": "Olivia",
        "memberSince": "2003-07-04T21:00:00.000+00:00",
        "memberTill": null,
        "gender": "f"
    },
    {
        "lastName": "Zhungwang",
        "firstName": "Ava",
        "memberSince": "2020-11-23T21:00:00.000+00:00",
        "memberTill": null,
        "gender": "f"
    },
    {
        "lastName": "Barret-Kingsley",
        "firstName": "Emma",
        "memberSince": "1997-09-11T21:00:00.000+00:00",
        "memberTill": null,
        "gender": "f"
    },
    {
        "lastName": "Jayi",
        "firstName": "William",
        "memberSince": "2010-11-11T22:00:00.000+00:00",
        "memberTill": null,
        "gender": "m"
    },
    {
        "lastName": "Chish",
        "firstName": "Elijah",
        "memberSince": "2006-07-07T21:00:00.000+00:00",
        "memberTill": null,
        "gender": "m"
    },
    {
        "lastName": "Ghaada",
        "firstName": "Charlotte",
        "memberSince": "2008-04-05T21:00:00.000+00:00",
        "memberTill": null,
        "gender": "f"
    },
    {
        "lastName": "Zhungwang",
        "firstName": "Noah",
        "memberSince": "2020-11-23T21:00:00.000+00:00",
        "memberTill": null,
        "gender": "m"
    },
    {
        "lastName": "Oomxii",
        "firstName": "Sophia",
        "memberSince": "2008-11-25T22:00:00.000+00:00",
        "memberTill": null,
        "gender": "f"
    },
    {
        "lastName": "Aexi",
        "firstName": "Liam",
        "memberSince": "2009-12-31T22:00:00.000+00:00",
        "memberTill": null,
        "gender": "m"
    }
	]


#
  b) returns all non-terminated users who have not currently borrowed anything
	
	
	http://localhost:1881/activeUsersWithNoBorrowing
	[
    {
        "lastName": "Augusta",
        "firstName": "Olivia",
        "memberSince": "2003-07-04T21:00:00.000+00:00",
        "memberTill": null,
        "gender": "f"
    },
    {
        "lastName": "Zhungwang",
        "firstName": "Ava",
        "memberSince": "2020-11-23T21:00:00.000+00:00",
        "memberTill": null,
        "gender": "f"
    },
    {
        "lastName": "Barret-Kingsley",
        "firstName": "Emma",
        "memberSince": "1997-09-11T21:00:00.000+00:00",
        "memberTill": null,
        "gender": "f"
    },
    {
        "lastName": "Jayi",
        "firstName": "William",
        "memberSince": "2010-11-11T22:00:00.000+00:00",
        "memberTill": null,
        "gender": "m"
    },
    {
        "lastName": "Chish",
        "firstName": "Elijah",
        "memberSince": "2006-07-07T21:00:00.000+00:00",
        "memberTill": null,
        "gender": "m"
    },
    {
        "lastName": "Ghaada",
        "firstName": "Charlotte",
        "memberSince": "2008-04-05T21:00:00.000+00:00",
        "memberTill": null,
        "gender": "f"
    },
    {
        "lastName": "Zhungwang",
        "firstName": "Noah",
        "memberSince": "2020-11-23T21:00:00.000+00:00",
        "memberTill": null,
        "gender": "m"
    },
    {
        "lastName": "Oomxii",
        "firstName": "Sophia",
        "memberSince": "2008-11-25T22:00:00.000+00:00",
        "memberTill": null,
        "gender": "f"
    },
    {
        "lastName": "Aexi",
        "firstName": "Liam",
        "memberSince": "2009-12-31T22:00:00.000+00:00",
        "memberTill": null,
        "gender": "m"
    }
	]
	
	
#
  c) returns all users who have borrowed a book on a given date
	
	http://localhost:1881/usersBorrowedOnGivenDate?date=09/16/2011
	
	[
    {
        "lastName": "Ghaada",
        "firstName": "Charlotte",
        "memberSince": "2008-04-05T21:00:00.000+00:00",
        "memberTill": null,
        "gender": "f"
    }
	]
	
#	
  d) returns all books borrowed by a given user in a given date range
	
	http://localhost:1881/booksBorrowedByUserGivenRange?startDate=04/20/2021&endDate=01/01/2022&firstName=Ava&lastName=Zhungwang
	
	[
    {
        "title": "Nature of Statistical Learning Theory, The",
        "author": "Vapnik, Vladimir",
        "genre": "data_science",
        "publisher": "Springer"
    },
    {
        "title": "Superfreakonomics",
        "author": "Dubner, Stephen",
        "genre": "economics",
        "publisher": "HarperCollins"
    },
    {
        "title": "Birth of a Theorem",
        "author": "Villani, Cedric",
        "genre": "mathematics",
        "publisher": "Bodley Head"
    }
	]
	
#	
  e) returns all available (not borrowed) books
	
	
	http://localhost:1881/availableBooks
	
	[
    {
        "title": "Freedom at Midnight",
        "author": "Lapierre, Dominique",
        "genre": "history",
        "publisher": "vikas"
    },
    {
        "title": "Great War for Civilization, The",
        "author": "Fisk, Robert",
        "genre": "history",
        "publisher": "HarperCollins"
    },
    {
        "title": "Beyond the Three Seas",
        "author": "Dalrymple, William",
        "genre": "history",
        "publisher": "Random House"
    },
    {
        "title": "Hunchback of Notre Dame, The",
        "author": "Hugo, Victor",
        "genre": "fiction",
        "publisher": "Random House"
    },
    {
        "title": "Age of Wrath, The",
        "author": "Eraly, Abraham",
        "genre": "history",
        "publisher": "Penguin"
    },
    {
        "title": "Down and Out in Paris & London",
        "author": "Orwell, George",
        "genre": "nonfiction",
        "publisher": "Penguin"
    },
    {
        "title": "Prisoner of Birth, A",
        "author": "Archer, Jeffery",
        "genre": "fiction",
        "publisher": "Pan"
    },
    {
        "title": "Analysis, Vol I",
        "author": "Tao, Terence",
        "genre": "mathematics",
        "publisher": "HBA"
    },
    {
        "title": "Statistical Decision Theory'",
        "author": "Pratt, John",
        "genre": "data_science",
        "publisher": "MIT Press"
    },
    {
        "title": "Computer Vision, A Modern Approach",
        "author": "Forsyth, David",
        "genre": "data_science",
        "publisher": "Pearson"
    },
    {
        "title": "Asami Asami",
        "author": "Deshpande, P L",
        "genre": "fiction",
        "publisher": "Mauj"
    },
    {
        "title": "Idea of Justice, The",
        "author": "Sen, Amartya",
        "genre": "nonfiction",
        "publisher": "Penguin"
    },
    {
        "title": "On Education",
        "author": "Russell, Bertrand",
        "genre": "philosophy",
        "publisher": "Routledge"
    },
    {
        "title": "Complete Sherlock Holmes, The - Vol I",
        "author": "Doyle, Arthur Conan",
        "genre": "fiction",
        "publisher": "Random House"
    },
    {
        "title": "Superfreakonomics",
        "author": "Dubner, Stephen",
        "genre": "economics",
        "publisher": "HarperCollins"
    },
    {
        "title": "Beautiful and the Damned, The",
        "author": "Deb, Siddhartha",
        "genre": "nonfiction",
        "publisher": "Penguin"
    },
    {
        "title": "Maugham's Collected Short Stories, Vol 3",
        "author": "Maugham, William S",
        "genre": "fiction",
        "publisher": "Vintage"
    },
    {
        "title": "False Impressions",
        "author": "Archer, Jeffery",
        "genre": "fiction",
        "publisher": "Pan"
    },
    {
        "title": "Moon is Down, The",
        "author": "Steinbeck, John",
        "genre": "fiction",
        "publisher": "Penguin"
    },
    {
        "title": "Hidden Connections, The",
        "author": "Capra, Fritjof",
        "genre": "science",
        "publisher": "HarperCollins"
    },
    {
        "title": "Rationality & Freedom",
        "author": "Sen, Amartya",
        "genre": "economics",
        "publisher": "Springer"
    },
    {
        "title": "Dylan on Dylan",
        "author": "Dylan, Bob",
        "genre": "nonfiction",
        "publisher": "Random House"
    },
    {
        "title": "Python for Data Analysis",
        "author": "McKinney, Wes",
        "genre": "data_science",
        "publisher": "O'Reilly"
    },
    {
        "title": "All the President's Men",
        "author": "Woodward, Bob",
        "genre": "history",
        "publisher": "Random House"
    },
    {
        "title": "Amulet of Samarkand, The",
        "author": "Stroud, Jonathan",
        "genre": "fiction",
        "publisher": "Random House"
    },
    {
        "title": "Drunkard's Walk, The",
        "author": "Mlodinow, Leonard",
        "genre": "science",
        "publisher": "Penguin"
    },
    {
        "title": "Once There Was a War",
        "author": "Steinbeck, John",
        "genre": "nonfiction",
        "publisher": "Penguin"
    },
    {
        "title": "Trial, The",
        "author": "Kafka, Frank",
        "genre": "fiction",
        "publisher": "Random House"
    },
    {
        "title": "Complete Mastermind, The",
        "author": "BBC",
        "genre": "nonfiction",
        "publisher": "BBC"
    },
    {
        "title": "God Created the Integers",
        "author": "Hawking, Stephen",
        "genre": "mathematics",
        "publisher": "Penguin"
    },
    {
        "title": "We the Living",
        "author": "Rand, Ayn",
        "genre": "fiction",
        "publisher": "Penguin"
    },
    {
        "title": "How to Think Like Sherlock Holmes",
        "author": "Konnikova, Maria",
        "genre": "psychology",
        "publisher": "Penguin"
    },
    {
        "title": "Freakonomics",
        "author": "Dubner, Stephen",
        "genre": "economics",
        "publisher": "Penguin"
    },
    {
        "title": "Story of Philosophy, The",
        "author": "Durant, Will",
        "genre": "philosophy",
        "publisher": "Pocket"
    },
    {
        "title": "Data Scientists at Work",
        "author": "Sebastian Gutierrez",
        "genre": "data_science",
        "publisher": "Apress"
    },
    {
        "title": "Free Will",
        "author": "Harris, Sam",
        "genre": "philosophy",
        "publisher": "FreePress"
    },
    {
        "title": "Last Lecture, The",
        "author": "Pausch, Randy",
        "genre": "nonfiction",
        "publisher": "Hyperion"
    },
    {
        "title": "Electric Universe",
        "author": "Bodanis, David",
        "genre": "science",
        "publisher": "Penguin"
    },
    {
        "title": "Complete Sherlock Holmes, The - Vol II",
        "author": "Doyle, Arthur Conan",
        "genre": "fiction",
        "publisher": "Random House"
    },
    {
        "title": "Image Processing & Mathematical Morphology",
        "author": "Shih, Frank",
        "genre": "signal_processing",
        "publisher": "CRC"
    },
    {
        "title": "Manasa",
        "author": "Kale, V P",
        "genre": "nonfiction",
        "publisher": "Mauj"
    },
    {
        "title": "Raisin in the Sun, A",
        "author": "Hansberry, Lorraine",
        "genre": "fiction",
        "publisher": "Penguin"
    },
    {
        "title": "To Sir With Love",
        "author": "Braithwaite",
        "genre": "fiction",
        "publisher": "Penguin"
    },
    {
        "title": "Pillars of the Earth, The",
        "author": "Follett, Ken",
        "genre": "fiction",
        "publisher": "Random House"
    },
    {
        "title": "Data Structures Using C & C++",
        "author": "Tanenbaum, Andrew",
        "genre": "computer_science",
        "publisher": "Prentice Hall"
    },
    {
        "title": "Doctor in the Nude",
        "author": "Gordon, Richard",
        "genre": "fiction",
        "publisher": "Penguin"
    },
    {
        "title": "Farewell to Arms, A",
        "author": "Hemingway, Ernest",
        "genre": "fiction",
        "publisher": "Rupa"
    },
    {
        "title": "Surely You're Joking Mr Feynman",
        "author": "Feynman, Richard",
        "genre": "science",
        "publisher": "Random House"
    },
    {
        "title": "New Machiavelli, The",
        "author": "Wells, H. G.",
        "genre": "fiction",
        "publisher": "Penguin"
    },
    {
        "title": "One",
        "author": "Bach, Richard",
        "genre": "nonfiction",
        "publisher": "Dell"
    },
    {
        "title": "Brethren, The",
        "author": "Grisham, John",
        "genre": "fiction",
        "publisher": "Random House"
    },
    {
        "title": "Russian Journal, A",
        "author": "Steinbeck, John",
        "genre": "nonfiction",
        "publisher": "Penguin"
    },
    {
        "title": "Return of the Primitive",
        "author": "Rand, Ayn",
        "genre": "philosophy",
        "publisher": "Penguin"
    },
    {
        "title": "Data Mining Handbook",
        "author": "Nisbet, Robert",
        "genre": "data_science",
        "publisher": "Apress"
    },
    {
        "title": "Integration of the Indian States",
        "author": "Menon, V P",
        "genre": "history",
        "publisher": "Orient Blackswan"
    },
    {
        "title": "Tales of Mystery and Imagination",
        "author": "Poe, Edgar Allen",
        "genre": "fiction",
        "publisher": "HarperCollins"
    },
    {
        "title": "Making Software",
        "author": "Oram, Andy",
        "genre": "computer_science",
        "publisher": "O'Reilly"
    },
    {
        "title": "Theory of Everything, The",
        "author": "Hawking, Stephen",
        "genre": "science",
        "publisher": "Jaico"
    },
    {
        "title": "Identity & Violence",
        "author": "Sen, Amartya",
        "genre": "philosophy",
        "publisher": "Penguin"
    },
    {
        "title": "Last Mughal, The",
        "author": "Dalrymple, William",
        "genre": "history",
        "publisher": "Penguin"
    },
    {
        "title": "Bookless in Baghdad",
        "author": "Tharoor, Shashi",
        "genre": "nonfiction",
        "publisher": "Penguin"
    },
    {
        "title": "Veteran, The",
        "author": "Forsyth, Frederick",
        "genre": "fiction",
        "publisher": "Transworld"
    },
    {
        "title": "Data Smart",
        "author": "Foreman, John",
        "genre": "data_science",
        "publisher": "Wiley"
    },
    {
        "title": "Age of Discontuinity, The",
        "author": "Drucker, Peter",
        "genre": "economics",
        "publisher": "Random House"
    },
    {
        "title": "Artist and the Mathematician, The",
        "author": "Aczel, Amir",
        "genre": "science",
        "publisher": "HighStakes"
    },
    {
        "title": "Zen & The Art of Motorcycle Maintenance",
        "author": "Pirsig, Robert",
        "genre": "philosophy",
        "publisher": "Vintage"
    },
    {
        "title": "Structure & Interpretation of Computer Programs",
        "author": "Sussman, Gerald",
        "genre": "computer_science",
        "publisher": "MIT Press"
    },
    {
        "title": "Textbook of Economic Theory",
        "author": "Stonier, Alfred",
        "genre": "economics",
        "publisher": "Pearson"
    },
    {
        "title": "Signal and the Noise, The",
        "author": "Silver, Nate",
        "genre": "data_science",
        "publisher": "Penguin"
    },
    {
        "title": "O Jerusalem!",
        "author": "Lapierre, Dominique",
        "genre": "history",
        "publisher": "vikas"
    },
    {
        "title": "Soft Computing & Intelligent Systems",
        "author": "Gupta, Madan",
        "genre": "data_science",
        "publisher": "Elsevier"
    },
    {
        "title": "Principles of Communication Systems",
        "author": "Taub, Schilling",
        "genre": "computer_science",
        "publisher": "TMH"
    },
    {
        "title": "Jurassic Park",
        "author": "Crichton, Michael",
        "genre": "fiction",
        "publisher": "Random House"
    },
    {
        "title": "Physics & Philosophy",
        "author": "Heisenberg, Werner",
        "genre": "science",
        "publisher": "Penguin"
    },
    {
        "title": "Maqta-e-Ghalib",
        "author": "Garg, Sanjay",
        "genre": "fiction",
        "publisher": "Mauj"
    },
    {
        "title": "Sea of Poppies",
        "author": "Ghosh, Amitav",
        "genre": "fiction",
        "publisher": "Penguin"
    },
    {
        "title": "In a Free State",
        "author": "Naipaul, V. S.",
        "genre": "fiction",
        "publisher": "Rupa"
    },
    {
        "title": "Burning Bright",
        "author": "Steinbeck, John",
        "genre": "fiction",
        "publisher": "Penguin"
    },
    {
        "title": "Machine Learning for Hackers",
        "author": "Conway, Drew",
        "genre": "data_science",
        "publisher": "O'Reilly"
    },
    {
        "title": "Slaughterhouse Five",
        "author": "Vonnegut, Kurt",
        "genre": "fiction",
        "publisher": "Random House"
    },
    {
        "title": "History of Western Philosophy",
        "author": "Russell, Bertrand",
        "genre": "philosophy",
        "publisher": "Routledge"
    },
    {
        "title": "Fundamentals of Wavelets",
        "author": "Goswami, Jaideva",
        "genre": "signal_processing",
        "publisher": "Wiley"
    },
    {
        "title": "Social Choice & Welfare, Vol 39 No. 1",
        "author": "Various",
        "genre": "economics",
        "publisher": "Springer"
    },
    {
        "title": "Let Us C",
        "author": "Kanetkar, Yashwant",
        "genre": "computer_science",
        "publisher": "Prentice Hall"
    },
    {
        "title": "Radiowaril Bhashane & Shrutika",
        "author": "Deshpande, P L",
        "genre": "nonfiction",
        "publisher": "Mauj"
    },
    {
        "title": "Great Indian Novel, The",
        "author": "Tharoor, Shashi",
        "genre": "fiction",
        "publisher": "Penguin"
    },
    {
        "title": "Uncommon Wisdom",
        "author": "Capra, Fritjof",
        "genre": "nonfiction",
        "publisher": "Fontana"
    },
    {
        "title": "Scoop!",
        "author": "Nayar, Kuldip",
        "genre": "history",
        "publisher": "HarperCollins"
    },
    {
        "title": "Orientalism",
        "author": "Said, Edward",
        "genre": "history",
        "publisher": "Penguin"
    },
    {
        "title": "New Markets & Other Essays",
        "author": "Drucker, Peter",
        "genre": "economics",
        "publisher": "Penguin"
    },
    {
        "title": "Journal of a Novel",
        "author": "Steinbeck, John",
        "genre": "fiction",
        "publisher": "Penguin"
    },
    {
        "title": "Aghal Paghal",
        "author": "Deshpande, P L",
        "genre": "nonfiction",
        "publisher": "Mauj"
    },
    {
        "title": "Catch 22",
        "author": "Heller, Joseph",
        "genre": "fiction",
        "publisher": "Random House"
    },
    {
        "title": "Gun Gayin Awadi",
        "author": "Deshpande, P L",
        "genre": "nonfiction",
        "publisher": "Mauj"
    },
    {
        "title": "India from Midnight to Milennium",
        "author": "Tharoor, Shashi",
        "genre": "history",
        "publisher": "Penguin"
    },
    {
        "title": "Crime and Punishment",
        "author": "Dostoevsky, Fyodor",
        "genre": "fiction",
        "publisher": "Penguin"
    },
    {
        "title": "Econometric Analysis",
        "author": "Greene, W. H.",
        "genre": "economics",
        "publisher": "Pearson"
    },
    {
        "title": "Ashenden of The British Agent",
        "author": "Maugham, William S",
        "genre": "fiction",
        "publisher": "Vintage"
    },
    {
        "title": "Clash of Civilizations and Remaking of the World Order",
        "author": "Huntington, Samuel",
        "genre": "history",
        "publisher": "Simon&Schuster"
    },
    {
        "title": "Learning OpenCV",
        "author": "Bradsky, Gary",
        "genre": "data_science",
        "publisher": "O'Reilly"
    },
    {
        "title": "Wealth of Nations, The",
        "author": "Smith, Adam",
        "genre": "economics",
        "publisher": "Random House"
    },
    {
        "title": "Angels & Demons",
        "author": "Brown, Dan",
        "genre": "fiction",
        "publisher": "Random House"
    },
    {
        "title": "Tao of Physics, The",
        "author": "Capra, Fritjof",
        "genre": "science",
        "publisher": "Penguin"
    },
    {
        "title": "Argumentative Indian, The",
        "author": "Sen, Amartya",
        "genre": "nonfiction",
        "publisher": "Picador"
    },
    {
        "title": "Introduction to Algorithms",
        "author": "Cormen, Thomas",
        "genre": "computer_science",
        "publisher": "MIT Press"
    },
    {
        "title": "Winter of Our Discontent, The",
        "author": "Steinbeck, John",
        "genre": "fiction",
        "publisher": "Penguin"
    },
    {
        "title": "City of Joy, The",
        "author": "Lapierre, Dominique",
        "genre": "fiction",
        "publisher": "vikas"
    },
    {
        "title": "Ahe Manohar Tari",
        "author": "Deshpande, Sunita",
        "genre": "nonfiction",
        "publisher": "Mauj"
    },
    {
        "title": "Outsider, The",
        "author": "Camus, Albert",
        "genre": "fiction",
        "publisher": "Penguin"
    }
	]

#
