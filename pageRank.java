import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class pageRank {
  private Map<String, Double> ranks = null;
  private Map<String, Map<String, Double>> links = null;
  private double dampingFactor = 0;
  private int numIterations = 0;

  public pageRank(double dampingFactor, int numIterations) {
    this.ranks = new HashMap<>();
    this.links = new HashMap<>();
    this.dampingFactor = dampingFactor;
    this.numIterations = numIterations;
  }

  public void addLink(String source, String destination, double weight) {
    Map<String, Double> destinations = links.get(source);
    if (destinations == null) {
      destinations = new HashMap<>();
      links.put(source, destinations);
    }
    destinations.put(destination, weight);
  }

  public void computeRanks() {
    // Initialize the ranks of all pages to 1.0
    for (String page : links.keySet()) {
      ranks.put(page, 1.0);
    }

    for (int i = 0; i < numIterations; i++) {
      Map<String, Double> newRanks = new HashMap<>();

      // Compute the rank of each page
      for (String page : ranks.keySet()) {
        // The damping factor is used to dampen the effect of incoming links.
        // It is a way to balance the importance of the current page's own rank
        // and the ranks of the pages linking to it.
        double newRank = (1 - dampingFactor) + dampingFactor * sumIncomingRanks(page);
        newRanks.put(page, newRank);
      }

      ranks = newRanks;
    }
  }
  public void addPage(String page) {
	    ranks.put(page, 1.0);
	    links.put(page, new HashMap<>());
	  }
  private double sumIncomingRanks(String page) {
    double sum = 0.0;
    for (Entry<String, Map<String, Double>> entry : links.entrySet()) {
      String source = entry.getKey();
      Map<String, Double> destinations = entry.getValue();
      if (destinations.containsKey(page)) {
        sum += ranks.get(source) / destinations.size();
      }
    }
    return sum;
  }

  public double getRank(String page) {
    return ranks.get(page);
  }
  public static void main(String[] args) {
	  pageRank pageRank = new pageRank(0.85,10);

	  // Add pages to the PageRank object
	  pageRank.addPage("page1");
	  pageRank.addPage("page2");
	  pageRank.addPage("page3");

	  // Add links between pages
	  pageRank.addLink("page1", "page2", 1.0);
	  pageRank.addLink("page1", "page3", 2.0);
	  pageRank.addLink("page2", "page1", 3.0);
	  pageRank.addLink("page3", "page1", 4.0);

	  // Compute the PageRanks of each page
	  pageRank.computeRanks();

	  // Print the PageRank of each page
	  System.out.println("PageRank of page1: " + pageRank.getRank("page1"));
	  System.out.println("PageRank of page2: " + pageRank.getRank("page2"));
	  System.out.println("PageRank of page3: " + pageRank.getRank("page3"));
	}

}
