package com.example.sahaf.service.impl;

import com.example.sahaf.convert.RentABookConverter;
import com.example.sahaf.dto.FindAllByStartDateResponse;
import com.example.sahaf.dto.RentABookDto;
import com.example.sahaf.dto.UserRentedBookInformationDto;
import com.example.sahaf.dto.UserRentedBookInformationResponse;
import com.example.sahaf.entities.Book;
import com.example.sahaf.entities.RentABook;
import com.example.sahaf.entities.User;
import com.example.sahaf.repository.RentABookRepository;
import com.example.sahaf.service.BookService;
import com.example.sahaf.service.RentABookService;
import com.example.sahaf.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RentABookServiceImpl implements RentABookService {

    private final RentABookRepository rentABookRepository;
    private final BookService bookService;
    private final UserService userService;
    private final RentABookConverter rentABookConverter;


    @Override
    public String rentedBook(RentABookDto rentABookDto) {
        RentABook rentABook = new RentABook();

        Book book = new Book();
        book.setId(rentABookDto.getBookId());

        User user = new User();
        user.setId(rentABookDto.getUserId());

        Date startDate = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(Calendar.MONTH, 1);

        Date endDate = calendar.getTime();

        rentABook.setId(rentABookDto.getId());
        rentABook.setStartDate(startDate);
        rentABook.setEndDate(endDate);
        rentABook.setBook(book);
        rentABook.setUser(user);

        this.rentABookRepository.save(rentABook);

        return "Başarılı";
    }

    @Override
    public List<RentABookDto> findAll() {

        return rentABookRepository.findAll().stream().map(rentABookConverter::rentABookConvertToRentABookDto).collect(Collectors.toList());
    }

    @Override
    public FindAllByStartDateResponse findAllByStartDate(String startDate) throws ParseException {

        Date date = new SimpleDateFormat("dd-MM-yyyy").parse(startDate);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, 23);
        calendar.add(Calendar.MINUTE, 59);
        Date endDate = calendar.getTime();


        List<RentABook> rentABookList = rentABookRepository.findAllByStartDateLessThanEqualAndStartDateGreaterThanEqual(endDate, date);

        List<RentABookDto> rentABookDtos = new ArrayList<>();

        rentABookList.forEach(rentABook -> {

            RentABookDto rentABookDto = rentABookConverter.rentABookConvertToRentABookDto(rentABook);

            rentABookDtos.add(rentABookDto);
        });
        FindAllByStartDateResponse findAllByStartDateResponse = new FindAllByStartDateResponse();
        findAllByStartDateResponse.setCount(rentABookDtos.size());
        findAllByStartDateResponse.setRentABookDtoList(rentABookDtos);

        return findAllByStartDateResponse;
    }

    @Override
    public UserRentedBookInformationResponse usersRentedBookInformation(String userName) {
        List<RentABook> rentABookList = rentABookRepository.findAllByUserName(userName);
        List<UserRentedBookInformationDto> dtos = new ArrayList<>();

        rentABookList.forEach(rentABook -> {

            UserRentedBookInformationDto userRentedBookInformationDto = rentABookConverter.rentABookDtoConvertToUserRentedBookInformationDto(rentABook);
            dtos.add(userRentedBookInformationDto);
        });
        UserRentedBookInformationResponse response = new UserRentedBookInformationResponse();
        response.setUserRentedBookInformationDtos(dtos);
        response.setCount(dtos.size());

        return response;
    }
}












