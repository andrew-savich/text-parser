package com.andrewsavich.textparser.model;

import java.util.List;

public interface CompositeComponent extends Component {
	List<Component> getComponents();
	
	void parse(String component);
	
	void add(Component component);
	
	void remove(Component component);
	
}