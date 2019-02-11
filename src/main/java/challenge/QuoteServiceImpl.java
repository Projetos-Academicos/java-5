package challenge;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteServiceImpl implements QuoteService {

	@Autowired
	private QuoteRepository repository;

	@Override
	public Quote getQuote() {
		List<Quote> listQuotes = repository.findAll();
		Random random = new Random();
		Quote quote = listQuotes.get(random.nextInt(listQuotes.size()-1));
		while(quote.getActor() == null) {
			quote = listQuotes.get(random.nextInt(listQuotes.size()-1));
		}
		return quote;
	}

	@Override
	public Quote getQuoteByActor(String actor) {
		List<Quote> listQuotes = repository.findByActor(actor);
		Random random = new Random();
		return listQuotes.get(random.nextInt(listQuotes.size()-1));
	}

}
