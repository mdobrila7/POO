package game.entity;

public final class Contract {
    private int consumerId;
    private int price;
    private int remainedContractMonths;

    private boolean postponed;

    public Contract(final int consumerId, final int price, final int remainedContractMonths) {
        this.consumerId = consumerId;
        this.price = price;
        this.remainedContractMonths = remainedContractMonths;
        this.postponed = false;
    }

    public int getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(final int consumerId) {
        this.consumerId = consumerId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(final int price) {
        this.price = price;
    }

    public int getRemainedContractMonths() {
        return remainedContractMonths;
    }

    public void setRemainedContractMonths(final int remainedContractMonths) {
        this.remainedContractMonths = remainedContractMonths;
    }

    ////////////////////////////////////////////////////////////////

    /**
     * Pay current Month
     */
    public void payMonth() {
        remainedContractMonths--;
        if (postponed) {
            postponed = false;
            remainedContractMonths--;
        }
    }

    /**
     * Checks if contract is over
     * @return
     */
    public boolean contractOver() {
        return remainedContractMonths <= 0;
    }

    /**
     * Gets contract Payment
     * @return
     */
    public int contractPayment() {
        if (!postponed) {
            return price;
        }
        int payment = (int) Math.round(Math.floor(1.2 * price));
        if (remainedContractMonths != 0) {
            payment += price;
        }
        return payment;
    }

    /**
     * Checks if the contract can be postponed
     * @return
     */
    public boolean canPostpone() {
        return !postponed;
    }

    /**
     * Postpone current month
     */
    public void postpone() {
        postponed = true;
    }

}
