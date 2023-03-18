class BrowserHistory {
    Page currentPage;
    Page homePage;

    public BrowserHistory(String homePage) {
        this.homePage = new Page(homePage);
        currentPage = this.homePage;
    }

    public void visit(String url) {
        Page newPage = new Page(url);
        currentPage.next = newPage;
        newPage.prev = currentPage;
        currentPage = newPage;
    }

    public String back(int steps) {
        while (steps > 0 && currentPage.prev != null) {
            currentPage = currentPage.prev;
            steps--;
        }
        return currentPage.url;
    }

    public String forward(int steps) {
        while (steps > 0 && currentPage.next != null) {
            currentPage = currentPage.next;
            steps--;
        }
        return currentPage.url;
    }
}

class Page {
    String url;
    Page prev, next;

    Page(String url) {
        this.url = url;
        this.prev = this.next = null;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homePage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */