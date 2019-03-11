package model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Library {
	  @JsonProperty("libraryname")
	  public String name;

	  @JsonProperty("mymusic")
	  public List<Song> songs;
	}
	
/*
  String jsonString = "{
 
	"libraryname":"My Library",
	"mymusic":[{"Artist Name":"Aaron","Song Name":"Beautiful"},
	{"Artist Name":"Britney","Song Name":"Oops I did It Again"},
{"Artist Name":"Britney","Song Name":"Stronger"}]}"

*/
	//Library lib = mapper.readValue(jsonString, Library.class);