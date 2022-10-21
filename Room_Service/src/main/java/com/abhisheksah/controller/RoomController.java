package com.abhisheksah.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhisheksah.model.Room;
import com.abhisheksah.repository.RoomRepository;
import com.abhisheksah.services.RoomService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/HMS/room")
public class RoomController {

	@Autowired
	private RoomService service;

	// this is the implementation part of logger
	private final static Logger Logger = LoggerFactory.getLogger(RoomController.class);

	// This is the postmapping to add the room

	@PostMapping("/addroom")
	public String addRoom(@RequestBody Room room) {
		try {
			this.service.addRoom(room);
			Logger.info("New Room added successfully:---" + room.getRoomId());
			return "Room added with roomNumber " + room.getRoomId();
		} catch (Exception e) {
			System.out.println(e);
			Logger.info("New Room added failed:---" + room.getRoomId());
			return "Use Valid Input";
		}
	}

	//this is the get request for all room
	@GetMapping("/allroom")
	public List<Room> getAllRooms() {

		try {

			return this.service.getAllRoom();

		} catch (Exception e) {
			System.out.println(e);
			Logger.info("------:Invalid:---");
			
			return null;
		}

	}

	
	//this is the get request to find the room by id
	@GetMapping("/get/{roomId}")
	public Optional<Room> getInventoryById(@PathVariable long roomId) {
		try {
			return this.service.getById(roomId);
		} catch (Exception e) {
			return null;
		}

	}

	@GetMapping("/getId/{roomId}")
	public Optional<Room> getRoomById(@PathVariable long roomId) {
			return this.service.getById(roomId);
	}
	
//this is the Put request to update the room data ...	
	@PutMapping("/update/{roomId}")
	public String updateRoom(@RequestBody Room room, @PathVariable long roomId) {
		try {
			this.service.updateRoom(room, roomId);
			return "Room updated with roomNumber " + roomId;
		} catch (Exception e) {
			System.out.println(e);
			return "Use Valid Input";
		}
	}

	//this is the delete request to to delete the data of room from the database
	@DeleteMapping("/delete/{roomId}")
	public String deleteRoom(@PathVariable long roomId) {
		try {
			this.service.deleteRoom(roomId);
			return "Room deleted with roomNumber " + roomId;
		} catch (Exception e) {
			System.out.println(e);
			return "Use Valid Input";
		}
	}
//this is the get method to find the room available or not use true to false to get the result
	@GetMapping("/search/{roomAvailable}")
	public List<Room> getAvailableRoom(@PathVariable boolean roomAvailable) {
		return this.service.getAvailableRoom(roomAvailable);
	}
}