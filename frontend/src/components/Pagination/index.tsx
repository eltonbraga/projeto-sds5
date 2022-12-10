import React from 'react';
import { SalePage } from '../../types/sale';

type Props = {
    page: SalePage
    onPageChange: Function;
}

const Pagination = ({ page, onPageChange }: Props) => {
    return (
        <div className="d-flex justify-content-center">
            <nav>
                <ul className="pagination">
                    <li className="page-item">
                        <button className={`page-link ${page.first ? 'disabled' : ''}`} onClick={() => onPageChange(page.number - 1)}>Anterior</button>
                    </li>
                    <li className="page-item disabled">
                        <span className="page-link">{page.number + 1}</span>
                    </li>
                    <li className={`page-item ${page.last ? 'disabled' : ''}`}>
                        <button className="page-link" onClick={() => onPageChange(page.number + 1)}>Próxima</button>
                    </li>
                </ul>
            </nav>
        </div>
    );
}

export default Pagination;