package br.com.springhibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.springhibernate.entity.Customer;
import br.com.springhibernate.service.interfaces.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomer(Model theModal) {

		// Buscando a lista de customers
		List<Customer> customers = customerService.getCustomers();

		// Adicionando no parametro da página
		theModal.addAttribute("customers", customers);

		// retornando a pagina
		return "list-customer";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModal) {

		// Criando variável para setar valor
		Customer customer = new Customer();

		// Pegando o modal da tela
		theModal.addAttribute("customer", customer);

		return "customer-form";
	}

	@PostMapping("/saveCustomer") 
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {

		customerService.saveCustomer(customer);

		return "redirect:/customer/list";
	}

	@GetMapping("/showFormForDelete")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {

		// delete customer from database
		customerService.deleteCustomer(id);

		return "redirect:/customer/list";
	}
}
