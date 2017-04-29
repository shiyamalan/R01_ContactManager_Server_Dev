package sg.dbsys.server.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sg.dbsys.server.models.Contact;

@Controller
public class PersonContactController {
	private final static org.slf4j.Logger logger = LoggerFactory
			.getLogger(PersonContactController.class);

	/**
	 * Get the contact information for a given name which is key in database
	 * 
	 * @param name
	 *            specify the contacts name {primary key}
	 * @return contact which satisfy the name in contact table
	 */
	@RequestMapping(value = "/getcontact/{name}", method = RequestMethod.GET)
	public @ResponseBody Contact getContact(@PathVariable String name) {
		Contact contact = new Contact();

		logger.debug("Contacts is loaded for a contact name {contact name = }",
				name);
		return contact;
	}

	/***
	 * Get the all contacts from database
	 * 
	 * @return all contacts from database as list format
	 */
	@RequestMapping(value = "/getcontacts/", method = RequestMethod.GET)
	public @ResponseBody List<Contact> getAllContacts() {
		List<Contact> contacts = new ArrayList<Contact>();

		int totalContacts = 0;
		logger.debug("Contacts is loaded for All {size of contacts = }",
				totalContacts);
		return contacts;
	}

	/**
	 * There are two version two load contacts as list format, due to
	 * performance reason we give the maximum number to load the contacts
	 * 
	 * @param maxCount
	 *            specify the how many contact you want
	 * @return contacts list, list top rank contacts as priority
	 */
	@RequestMapping(value = "/getcontacts/{maxCount}", method = RequestMethod.GET)
	public @ResponseBody List<Contact> getFirstContacts(
			@PathVariable int maxCount) {
		List<Contact> contacts = new ArrayList<Contact>();

		logger.debug(
				"@{getFirstContacts}Contacts is loaded for specific size: {size of contacts = }",
				maxCount);
		return contacts;
	}

}
