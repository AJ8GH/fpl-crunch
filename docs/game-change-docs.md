# A Complete Guide to the Fantasy Premier League (FPL) API

From: [GameChange](https://www.game-change.co.uk/fpl-tools/)

## What is the FPL API?

in layman’s terms, the FPL API is a series of URL endpoints that allow you to retrieve data from the FPL site in json format (key value pairs in curly brackets), which you can use for yourself in any
apps you create.

Every endpoint begins with the /api/ parameter, so every fall you make will be:

https://www.fantasy.premierleague.com/api/{some-other-parameter-here}

For any of the examples below, if you just put them into your URL tab, you’ll see the json returned in the browser.

## General Information

### Bootstrap Static

The ‘bootstrap-static’ call returns a huge amount of information, and is all you really need if you don’t want to get into specific FPL managed teams.

**Full URL**: https://fantasy.premierleague.com/api/bootstrap-static/

**Data included**:

* A summary of all 38 gameweeks
* The game’s settings
* Basic information on all 20 PL teams
* Total number of FPL Users and overall chip usage
* Basic information on all Premier League players
* List of stats that FPL keeps track of
* The different FPL positions

## Fixtures

This call shows some useful information on every single fixture that has happened, as well as placeholder info for upcoming gameweeks/fixtures. For past fixtures, you’ll need to know the IDs of the
teams from the bootstrap-static call.

**Full URL**: https://fantasy.premierleague.com/api/fixtures/

**Data included**: Per match, it shows:

* Goals
* Assists
* Cards
* Saves
* Pens missed
* Bonus points
* Own goals
* Pens saved

## Individual Premier League Players

### Player Summary

This one is handy if you want in-depth info on a specific player, including past performance and upcoming fixtures. You’ll need to grab the player’s ID from the bootstrap-static call.

**Full URL**: https://fantasy.premierleague.com/api/element-summary/{player-id}/

**Data included**:

* Remaining fixtures for the player, including:
* Kickoff time
* Gameweek number
* Home or Away
* Difficulty
* Previous fixtures and performance, including:
* Minutes played
* Goals
* Assists
* Conceded
* Cards
* Bonus
* Influence
* Creativity
* xG
* xA
* Value
* Transfer delta for that gameweek

### Gameweek Summary

There’s also an additional URL that allows you to view the performance of all players for a specified gameweek.

**Full URL**: https://fantasy.premierleague.com/api/event/{GW}/live/

**Data included**: Shows all of the above stats, but for the gameweek for every player, rather than a single player for every gameweek.

## Individual FPL Managers

Using this set of endpoints, you can retrieve information on any individual FPL manager. Your manager ID can be found on the my-team page in the URL.

### Team

**Full URL**: https://fantasy.premierleague.com/api/entry/{team-id}/

**Data included**:

* Name
* Team Name
* Favourite team
* Gameweek started
* Points
* Transfers
* Overall Rank
* Last gameweek rank
* Last gameweek points
* All league information, including:
* Max entries
* Scoring type
* Cup qualification
* Your rank within the league
* League name
* Date created

### Transfers

**Full URL**: https://fantasy.premierleague.com/api/entry/{team-id}/transfers/

**Data included**: A full history of transfers for that manager, including:

* Cost
* Gameweek
* Time of transfer
* Players in and out

### Picks

**Full URL**: https://fantasy.premierleague.com/api/entry/{team-id}/event/{GW}/picks/

**Data included**: Shows the detail of your 15 players for any given gameweek. the ‘Event’ parameter in the URL is the gameweek number. This includes the general info for the gameweek, such as:

* Points
* Total points
* Rank
* Team value
* Money in the bank
* Transfers made that gameweek
* The stats of the individual players in the team, including:
* Element ID (cross reference with bootstrap-static data)
* Whether they’re captain or vice captain
* Position in the team

### History

**Full URL**: https://fantasy.premierleague.com/api/entry/{team-id}/history/

**Data included**: This shows a high level stats for each gameweek gone by, plus the manager’s overall career performance form previous seasons, gameweek-by-gameweek data, including:

* Points
* Rank
* Overall rank
* Money in the Bank
* Team value
* Transfers made
* Chips played
* Past season history data, including:
* Season year
* Overall points
* Overall rank

## Leagues

### FPL Classic Leagues

This endpoint breaks down the managers within a league, showing their relative ranking and high level data for each.

**Full URL**: https://fantasy.premierleague.com/api/leagues-classic/{league-id}/standings/

**Data included**:

* League name
* Date created
* Admin ID
* Closed or open
* Cup activated
* Individual manager/team data, including:
* Manager name
* Team name
* Current league rank
* Last week’s rank
* Entry ID
* Total Points

### FPL Classic Leagues Paginated

If there are multiple pages to the league because there are lots of managers competing in it, add the page_standings parameter to the end, with the desired page number, as below:

**Full URL**: https://fantasy.premierleague.com/api/leagues-classic/314/standings/?page_standings=number

### FPL Head-to-Head League

Shows the current standings of a head-2-head league.

**Full URL**: https://fantasy.premierleague.com/api/leagues-h2h-matches/league/{league-ID}/

**Data included**:

* New entries
* Last updated data
* League:
* ID
* Name
* Created date
* Closed
* Max entries
* League type
* Scoring type
* Start event
* Privacy setting
* Has cup
* Cup league
* Cup round
* Standings for each player, with:
* ID
* Division
* Entry
* Player name
* Rank
* Last rank
* Rank sort
* Total points
* Team name
* Played
* Won
* Drawn
* Lost
* FPL Points

## Bonus tips

* Always end the URL with a trailing forward slash ‘/’, or else it won’t retrieve the data.
* If you’re making these calls via the front-end browser within an app, you’ll have to use a proxy to avoid CORS errors.
* Occasionally during the off-season, FPL make changes to the format of the calls.
* Always check during the summer whether anything has changed if you publish any tools or apps.
