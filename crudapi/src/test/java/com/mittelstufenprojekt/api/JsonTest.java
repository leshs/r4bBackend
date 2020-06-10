package com.mittelstufenprojekt.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonTest {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper().configure(SerializationFeature.INDENT_OUTPUT, true);
/*
    @Test
    public void testJsonParsing() throws JsonProcessingException {
        LessonDTO lessonDTO = new LessonDTO();
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setInfo("gitarre solop");
        subjectDTO.setName("gitarre");
        lessonDTO.setSubjectDTO(subjectDTO);
        lessonDTO.setDate("2020-02-03");

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setBirthdate("2020-02-03");
        customerDTO.setBirthplace("ort");
        customerDTO.setEmail("sdfda@sdf.de");
        customerDTO.setFirstname("firstname");
        customerDTO.setLastname("lastname");

        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setCity("city");
        addressDTO.setNumber("32");
        addressDTO.setStreet("straße");
        addressDTO.setZipcode(12313);
        customerDTO.setAddressDTO(addressDTO);

        List<CustomerDTO> customers = new ArrayList<>();
        customers.add(customerDTO);
        lessonDTO.setCustomerDTOList(customers);
        String s = OBJECT_MAPPER.writeValueAsString(lessonDTO);
        System.out.println(s);
    }

 */
}
