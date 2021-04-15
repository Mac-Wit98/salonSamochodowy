package proj;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController implements ErrorController  {
	@Autowired
	private ModeleDAO dao;
	@Autowired
	private MarkiDAO markiDao;
	@Autowired
	private SamochodyDAO samochodyDao;
	@Autowired
	private AdresyDAO adresyDao;
	@Autowired
	private PocztyDAO pocztyDao;
	@Autowired
	private TransakcjeDAO transakcjeDao;
	@Autowired
	private KlienciDAO klienciDao;
	@Autowired
	private PracowinicyDAO pracownicyDao;
	@Autowired
	private Egzemplarze_samDAO egzDao;

	/*
	 * Home page
	 *
	 */
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		return "home";
	}

	/*
	 * Home page
	 *
	 */
	@RequestMapping("/admin")
	public String viewHomeAdminPage(Model model) {
		return "homeAdmin";
	}

	@RequestMapping("/emplo")
	public String viewHomeEmploPage(Model model) {
		return "homeEmplo";
	}

	@RequestMapping("/user")
	public String viewHomeUserPage(Model model) {
		return "homeUser";
	}

	/*
	 * 
	 * Brak uprawnieñ
	 * 
	 */

	@RequestMapping("/brakDostepu")
	public String viewWrongAccessPage(Model model) {
		return "noAccess";
	}
	/*
	 * 
	 * Do b³edów
	 * 
	 */
	@RequestMapping("/error")
	public String viewError(HttpServletRequest request) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
	    
	    if (status != null) {
	        Integer statusCode = Integer.valueOf(status.toString());
	    
	        if(statusCode == HttpStatus.NOT_FOUND.value()) {
	            return "error-404";
	        }
	        else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
	            return "error-500";
	        }
	    }
	    return "error";
	}
    @Override
    public String getErrorPath() {
        return "null";
    }


	/*
	 * Do Modele
	 */
	@RequestMapping("/modele")
	public String viewModelPage(Model model) {
		List<Modele> listModele = dao.list();
		model.addAttribute("listModele", listModele);
		return "modele";
	}

	@RequestMapping("/modeleEU")
	public String viewModelEUPage(Model model) {
		List<Modele> listModele = dao.list();
		model.addAttribute("listModele", listModele);
		return "modeleEU";
	}

	@RequestMapping("/newModele")
	public String showNewForm(Model model) {
		Modele modele = new Modele();
		model.addAttribute("modele", modele);
		return "newModel";
	}

	@RequestMapping(value = "/saveModele", method = RequestMethod.POST)
	public String saveModele(@ModelAttribute("modele") Modele modele) {
		dao.save(modele);

		return "redirect:/modele";
	}

	@RequestMapping("modele/edit/{nr_modelu}")
	public ModelAndView showEditFormModele(@PathVariable(name = "nr_modelu") int nrModelu) {
		ModelAndView mav = new ModelAndView("editModele");
		Modele modele = dao.get(nrModelu);
		mav.addObject("modele", modele);
		return mav;
	}

	@RequestMapping(value = "/updateModele", method = RequestMethod.POST)
	public String updateModele(@ModelAttribute("modele") Modele modele) {
		dao.update(modele);
		return "redirect:/modele";
	}

	@RequestMapping("modele/delete/{nr_modelu}")
	public String deleteModele(@PathVariable(name = "nr_modelu") int nrModelu) {
		dao.delete(nrModelu);
		return "redirect:/modele";
	}

	/*
	 * Do Marki
	 * 
	 */
	@RequestMapping("/marki")
	public String viewMarkiPage(Model model) {
		List<Marki> listMarki = markiDao.list();
		model.addAttribute("listMarki", listMarki);
		return "marki";
	}

	@RequestMapping("/markiEU")
	public String viewMarkiEUPage(Model model) {
		List<Marki> listMarki = markiDao.list();
		model.addAttribute("listMarki", listMarki);
		return "markiEU";
	}

	@RequestMapping("/newMarki")
	public String showNewFormMarki(Model model) {
		Marki marki = new Marki();
		model.addAttribute("marki", marki);
		return "newMarki";
	}

	@RequestMapping(value = "/saveMarki", method = RequestMethod.POST)
	public String saveMarki(@ModelAttribute("marki") Marki marki) {
		markiDao.save(marki);

		return "redirect:/marki";
	}

	@RequestMapping("marki/edit/{nr_marki}")
	public ModelAndView showEditFormMarki(@PathVariable(name = "nr_marki") int nr_marki) {
		ModelAndView mav = new ModelAndView("editMarki");
		Marki marki = markiDao.get(nr_marki);
		mav.addObject("marki", marki);
		return mav;
	}

	@RequestMapping(value = "/updateMarki", method = RequestMethod.POST)
	public String updateMarki(@ModelAttribute("marki") Marki marki) {
		markiDao.update(marki);
		return "redirect:/marki";
	}

	@RequestMapping("marki/delete/{nr_marki}")
	public String deleteMarki(@PathVariable(name = "nr_marki") int nr_marki) {
		markiDao.delete(nr_marki);
		return "redirect:/marki";
	}

	/*
	 * 
	 * Do samochodów
	 * 
	 */

	@RequestMapping("/samochody")
	public String viewSamochodyPage(Model model) {
		List<Samochody> listSamochody = samochodyDao.list();
		model.addAttribute("listSamochody", listSamochody);
		return "samochody";
	}

	@RequestMapping("/samochodyEU")
	public String viewSamochodyEUPage(Model model) {
		List<Samochody> listSamochody = samochodyDao.list();
		model.addAttribute("listSamochody", listSamochody);
		return "samochodyEU";
	}

	@RequestMapping("/newSamochody")
	public String showNewFormSamochody(Model model) {
		Samochody samochody = new Samochody();
		model.addAttribute("samochody", samochody);
		return "newSamochody";
	}

	@RequestMapping(value = "/saveSamochody", method = RequestMethod.POST)
	public String saveSamochody(@ModelAttribute("samochody") Samochody samochody) {
		samochodyDao.save(samochody);

		return "redirect:/samochody";
	}

	@RequestMapping("samochody/edit/{nr_samochodu}")
	public ModelAndView showEditFormSamochody(@PathVariable(name = "nr_samochodu") int nr_samochodu) {
		ModelAndView mav = new ModelAndView("editSamochody");
		Samochody samochody = samochodyDao.get(nr_samochodu);
		mav.addObject("samochody", samochody);
		return mav;
	}

	@RequestMapping(value = "/updateSamochody", method = RequestMethod.POST)
	public String updateSamochody(@ModelAttribute("samochody") Samochody samochody) {
		samochodyDao.update(samochody);
		return "redirect:/samochody";
	}

	@RequestMapping("samochody/delete/{nr_samochodu}")
	public String deleteSamochody(@PathVariable(name = "nr_samochodu") int nr_samochodu) {
		samochodyDao.delete(nr_samochodu);
		return "redirect:/samochody";
	}

	/*
	 * Do Adresy
	 * 
	 */
	@RequestMapping("/adresy")
	public String viewAdresyPage(Model model) {
		List<Adresy> listAdresy = adresyDao.list();
		model.addAttribute("listAdresy", listAdresy);
		return "adresy";
	}

	@RequestMapping("/adresyEU")
	public String viewAdresyEUPage(Model model) {
		List<Adresy> listAdresy = adresyDao.list();
		model.addAttribute("listAdresy", listAdresy);
		return "adresyEU";
	}

	@RequestMapping("/newAdresy")
	public String showNewFormAdresy(Model model) {
		Adresy adresy = new Adresy();
		model.addAttribute("adresy", adresy);
		return "newAdresy";
	}

	@RequestMapping(value = "/saveAdresy", method = RequestMethod.POST)
	public String saveAdresy(@ModelAttribute("adresy") Adresy adresy) {
		adresyDao.save(adresy);

		return "redirect:/adresy";
	}

	@RequestMapping("adresy/edit/{nr_adresu}")
	public ModelAndView showEditFormAdresy(@PathVariable(name = "nr_adresu") int nr_adresu) {
		ModelAndView mav = new ModelAndView("editAdresy");
		Adresy adresy = adresyDao.get(nr_adresu);
		mav.addObject("adresy", adresy);
		return mav;
	}

	@RequestMapping(value = "/updateAdresy", method = RequestMethod.POST)
	public String updateAdresy(@ModelAttribute("adresy") Adresy adresy) {
		adresyDao.update(adresy);
		return "redirect:/adresy";
	}

	@RequestMapping("adresy/delete/{nr_adresu}")
	public String deleteAdresy(@PathVariable(name = "nr_adresu") int nr_adresu) {
		adresyDao.delete(nr_adresu);
		return "redirect:/adresy";
	}

	/*
	 * 
	 * Do Poczty
	 * 
	 */
	@RequestMapping("/poczty")
	public String viewPocztyPage(Model model) {
		List<Poczty> listPoczty = pocztyDao.list();
		model.addAttribute("listPoczty", listPoczty);
		return "poczty";
	}

	@RequestMapping("/pocztyEU")
	public String viewPocztyEUPage(Model model) {
		List<Poczty> listPoczty = pocztyDao.list();
		model.addAttribute("listPoczty", listPoczty);
		return "pocztyEU";
	}

	@RequestMapping("/newPoczty")
	public String showNewFormPoczty(Model model) {
		Poczty poczty = new Poczty();
		model.addAttribute("poczty", poczty);
		return "newPoczty";
	}

	@RequestMapping(value = "/savePoczty", method = RequestMethod.POST)
	public String savePoczty(@ModelAttribute("poczty") Poczty poczty) {
		pocztyDao.save(poczty);

		return "redirect:/poczty";
	}

	@RequestMapping("poczty/edit/{nr_poczty}")
	public ModelAndView showEditFormPoczty(@PathVariable(name = "nr_poczty") int nr_poczty) {
		ModelAndView mav = new ModelAndView("editPoczty");
		Poczty poczty = pocztyDao.get(nr_poczty);
		mav.addObject("poczty", poczty);
		return mav;
	}

	@RequestMapping(value = "/updatePoczty", method = RequestMethod.POST)
	public String updatePoczty(@ModelAttribute("poczty") Poczty poczty) {
		pocztyDao.update(poczty);
		return "redirect:/poczty";
	}

	@RequestMapping("poczty/delete/{nr_poczty}")
	public String deletePOczty(@PathVariable(name = "nr_poczty") int nr_poczty) {
		pocztyDao.delete(nr_poczty);
		return "redirect:/poczty";
	}

	/*
	 * 
	 * Do Transakcji
	 * 
	 * 
	 */
	@RequestMapping("/transakcje")
	public String viewTransakcjePage(Model model) {
		List<Transakcje> listTransakcje = transakcjeDao.list();
		model.addAttribute("listTransakcje", listTransakcje);
		return "transakcje";
	}

	@RequestMapping("/newTransakcje")
	public String showNewFormTransakcje(Model model) {
		Transakcje transakcje = new Transakcje();
		model.addAttribute("transakcje", transakcje);
		return "newTransakcje";
	}

	@RequestMapping(value = "/saveTransakcje", method = RequestMethod.POST)
	public String saveTransakcje(@ModelAttribute(" transakcje") Transakcje transakcje) {
		transakcjeDao.save(transakcje);

		return "redirect:/transakcje";
	}

	@RequestMapping("transakcje/edit/{nr_transakcji}")
	public ModelAndView showEditFormTransakcje(@PathVariable(name = "nr_transakcji") int nr_transakcji) {
		ModelAndView mav = new ModelAndView("editTransakcje");
		Transakcje transakcje = transakcjeDao.get(nr_transakcji);
		mav.addObject("transakcje", transakcje);
		return mav;
	}

	@RequestMapping(value = "/updateTransakcje", method = RequestMethod.POST)
	public String updateTransakcje(@ModelAttribute("transakcje") Transakcje transakcje) {
		transakcjeDao.update(transakcje);
		return "redirect:/transakcje";
	}

	@RequestMapping("transakcje/delete/{nr_transakcji}")
	public String deleteTranakcje(@PathVariable(name = "nr_transakcji") int nr_transakcji) {
		transakcjeDao.delete(nr_transakcji);
		return "redirect:/transakcje";
	}

	/*
	 * 
	 * Do Klienci
	 * 
	 * 
	 */
	@RequestMapping("/klienci")
	public String viewKlienciPage(Model model) {
		List<Klienci> listKlienci = klienciDao.list();
		model.addAttribute("listKlienci", listKlienci);
		return "klienci";
	}
	@RequestMapping("/klientDane")
	public String viewKlientiPage(Model model) {
		Klienci klient = klienciDao.get(3);
		model.addAttribute("klient", klient);
		return "klient";
	}

	@RequestMapping("/newKlienci")
	public String showNewFormKlienci(Model model) {
		Klienci klienci = new Klienci();
		model.addAttribute("klienci", klienci);
		return "newKlienci";
	}

	@RequestMapping(value = "/saveKlienci", method = RequestMethod.POST)
	public String saveKlienci(@ModelAttribute("klienci") Klienci klienci) {
		klienciDao.save(klienci);

		return "redirect:/klienci";
	}

	@RequestMapping("klienci/edit/{nr_klienta}")
	public ModelAndView showEditFormKlienci(@PathVariable(name = "nr_klienta") int nr_klienta) {
		ModelAndView mav = new ModelAndView("editKlienci");
		Klienci klienci = klienciDao.get(nr_klienta);
		mav.addObject("klienci", klienci);
		return mav;
	}

	@RequestMapping(value = "/updateKlienci", method = RequestMethod.POST)
	public String updateklienci(@ModelAttribute("klienci") Klienci klienci) {
		klienciDao.update(klienci);
		return "redirect:/klienci";
	}

	@RequestMapping("klienci/delete/{nr_klienta}")
	public String deleteKlienci(@PathVariable(name = "nr_klienta") int nr_klienta) {
		klienciDao.delete(nr_klienta);
		return "redirect:/klienci";
	}

	/*
	 * 
	 * Do pracowników
	 * 
	 */
	@RequestMapping("/pracownicy")
	public String viewPracownicyPage(Model model) {
		List<Pracownicy> listPracownicy = pracownicyDao.list();
		model.addAttribute("listPracownicy", listPracownicy);
		return "pracownicy";
	}
	@RequestMapping("/pracownik")
	public String viewPracownikPage(Model model) {
		Pracownicy pracownik = pracownicyDao.get(3);
		model.addAttribute("pracownik", pracownik);
		return "pracownik";
	}
	@RequestMapping("/newPracownicy")
	public String showNewFormPracownicyi(Model model) {
		Pracownicy pracownicy = new Pracownicy();
		model.addAttribute("pracownicy", pracownicy);
		return "newPracownicy";
	}

	@RequestMapping(value = "/savePracownicy", method = RequestMethod.POST)
	public String savePracownicy(@ModelAttribute("pracownicy") Pracownicy pracownicy) {
		pracownicyDao.save(pracownicy);

		return "redirect:/pracownicy";
	}

	@RequestMapping("pracownicy/edit/{nr_pracownika}")
	public ModelAndView showEditFormPracownicy(@PathVariable(name = "nr_pracownika") int nr_pracownika) {
		ModelAndView mav = new ModelAndView("editPracownicy");
		Pracownicy pracownicy = pracownicyDao.get(nr_pracownika);
		mav.addObject("pracownicy", pracownicy);
		return mav;
	}

	@RequestMapping(value = "/updatePracownicy", method = RequestMethod.POST)
	public String updatePracownicy(@ModelAttribute("pracownicy") Pracownicy pracownicy) {
		pracownicyDao.update(pracownicy);
		return "redirect:/pracownicy";
	}

	@RequestMapping("pracownicy/delete/{nr_pracownika}")
	public String deletePracownicy(@PathVariable(name = "nr_pracownika") int nr_pracownika) {
		pracownicyDao.delete(nr_pracownika);
		return "redirect:/pracownicy";
	}

	/*
	 * 
	 * Do egzemplarzu_sam
	 * 
	 * 
	 */
	@RequestMapping("/egzemplarze")
	public String viewEgzemSamPage(Model model) {
		List<Egzemplarze_sam> listEgzemplarze = egzDao.list();
		model.addAttribute("listEgzemplarze", listEgzemplarze);
		return "egzemplarze";
	}

	@RequestMapping("/egzemplarzeEU")
	public String viewEgzemEUSamPage(Model model) {
		List<Egzemplarze_sam> listEgzemplarze = egzDao.list();
		model.addAttribute("listEgzemplarze", listEgzemplarze);
		return "egzemplarzeEU";
	}

	@RequestMapping("/newEgzemplarze")
	public String showNewFormEgzemplarze(Model model) {
		Egzemplarze_sam egzemplarze = new Egzemplarze_sam();
		model.addAttribute("egzemplarze", egzemplarze);
		return "newEgzemplarze";
	}

	@RequestMapping(value = "/saveEgzemplarze", method = RequestMethod.POST)
	public String saveEgzemplarze(@ModelAttribute("egzemplarze") Egzemplarze_sam egzemplarze) {
		egzDao.save(egzemplarze);

		return "redirect:/egzemplarze";
	}

	@RequestMapping("egzemplarze/edit/{nr_egzemplarzu}")
	public ModelAndView showEditFormEgzemplarzu(@PathVariable(name = "nr_egzemplarzu") int nr_egzemplarzu) {
		ModelAndView mav = new ModelAndView("editEgzemplarze");
		Egzemplarze_sam egzemplarze = egzDao.get(nr_egzemplarzu);
		mav.addObject("egzemplarze", egzemplarze);
		return mav;
	}

	@RequestMapping(value = "/updateEgzemplarze", method = RequestMethod.POST)
	public String updatePracownicy(@ModelAttribute("egzemplarze") Egzemplarze_sam egzemplarze) {
		egzDao.update(egzemplarze);
		return "redirect:/egzemplarze";
	}

	@RequestMapping("egzemplarze/delete/{nr_egzemplarzu}")
	public String deleteEgzemplarze(@PathVariable(name = "nr_egzemplarzu") int nr_egzemplarzu) {
		egzDao.delete(nr_egzemplarzu);
		return "redirect:/egzemplarze";
	}
}
